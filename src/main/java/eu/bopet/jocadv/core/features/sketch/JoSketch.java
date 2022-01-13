package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.constraints.sketch.PointToPlaneDistance;
import eu.bopet.jocadv.core.constraints.sketch.PointToPointDistance;
import eu.bopet.jocadv.core.constraints.sketch.SketchConstraint;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.FeatureBase;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoCoSys;
import eu.bopet.jocadv.core.features.vector.JoValue;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.linear.SingularValueDecomposition;

import java.util.ArrayList;
import java.util.List;

public class JoSketch extends FeatureBase implements Feature, RegenerativeLink {

    private static final int MAX_ITERATIONS = 31;

    private final List<Feature> references;
    private final List<SketchGeometry> geometries;
    private final List<SketchConstraint> constraints;
    private final List<SketchConstraint> constraintsInSolver;
    private final List<SketchConstraint> canBeRemoved;
    private final List<JoPoint> points;
    private final JoCoSys coSys;
    private final RegenerativeLink regenerativeLink;
    private final List<JoValue> valueList;
    private final List<JoValue> variables;
    private int difference;
    private SketchConstraint lastConstraint;
    private boolean edit;

    public JoSketch(JoCoSys coSys, RegenerativeLink regenerativeLink) {
        this.coSys = coSys;
        this.regenerativeLink = regenerativeLink;
        references = new ArrayList<>();
        geometries = new ArrayList<>();
        constraints = new ArrayList<>();
        canBeRemoved = new ArrayList<>();
        constraintsInSolver = new ArrayList<>();
        points = new ArrayList<>();
        valueList = new ArrayList<>();
        variables = new ArrayList<>();
        edit = false;
        edit();
    }

    public List<SketchConstraint> getConstraints() {
        return constraints;
    }

    public void edit() {
        if (edit) return;
        for (SketchGeometry geometry : geometries) {
            for (JoValue value : geometry.getValues()) {
                value.setStatus(JoValue.VARIABLE);
            }
        }
        edit = true;
    }

    public void close() {
        if (edit) {
            for (SketchGeometry geometry : geometries) {
                for (JoValue value : geometry.getValues()) {
                    value.setStatus(JoValue.FIX);
                }
            }
        }
        edit = false;
    }

    public void addGeometry(SketchGeometry newGeometry) {
        if (geometries.contains(newGeometry)) return;
        geometries.add(newGeometry);
        for (JoValue value : newGeometry.getValues()) {
            value.setStatus(JoValue.VARIABLE);
        }
        if (newGeometry instanceof JoPoint) {
            JoPoint point = (JoPoint) newGeometry;
            // Z
            PointToPlaneDistance pointToPlaneDistance = new PointToPlaneDistance(
                    coSys.getXy(),
                    point,
                    new JoValue(JoValue.CONSTANT, 0.0),
                    SketchConstraint.SYSTEM);
            addConstraint(pointToPlaneDistance);
            // X
            JoValue distanceX = new JoValue(JoValue.AUTO, 0.0);
            PointToPlaneDistance pointToPlaneDistanceYZ = new PointToPlaneDistance(
                    this.coSys.getYz(), point, distanceX, SketchConstraint.AUTO_CONSTRAINT);
            double realDistanceX = pointToPlaneDistanceYZ.getFunctionValue();
            distanceX.set(realDistanceX);
            addConstraint(pointToPlaneDistanceYZ);
            // Y
            JoValue distanceY = new JoValue(JoValue.AUTO, 0.0);
            PointToPlaneDistance pointToPlaneDistanceXZ = new PointToPlaneDistance(
                    this.coSys.getXz(), point, distanceY, SketchConstraint.AUTO_CONSTRAINT);
            double realDistanceY = pointToPlaneDistanceXZ.getFunctionValue();
            distanceY.set(realDistanceY);
            addConstraint(pointToPlaneDistanceXZ);
            return;
        }
        for (JoPoint point : newGeometry.getPoints()) {
            addGeometry(point);
            if (!points.contains(point)) points.add(point);
        }
        if (newGeometry instanceof JoArc) {
            JoArc arc = (JoArc) newGeometry;
            JoPoint point1 = arc.get1stPoint();
            JoPoint point2 = arc.get2ndPoint();
            JoPoint center = arc.getCircle().getSphere().getCenter();
            PointToPointDistance pointToPointDistance1 = new PointToPointDistance(
                    point1, center, arc.getRadius(), SketchConstraint.SYSTEM);
            PointToPointDistance pointToPointDistance2 = new PointToPointDistance(
                    center, point2, arc.getRadius(), SketchConstraint.SYSTEM);
            addConstraint(pointToPointDistance1);
            addConstraint(pointToPointDistance2);
        }
    }

    public void addConstraint(SketchConstraint newConstraint) {
        List<Object> components = newConstraint.getComponents();
        for (SketchConstraint constraint : constraints) {
            if (constraint.getClass().equals(newConstraint.getClass())) {
                if (constraint.getComponents().containsAll(components)) {
                    System.out.println("Constraint already exists.");
                    return;
                }
            }
        }
        constraints.add(newConstraint);
        for (Object object : components) {
            if (object instanceof Feature && !geometries.contains(object)) {
                Feature feature = (Feature) object;
                if (!references.contains(feature)) {
                    references.add(feature);
                }
            }
        }
        lastConstraint = newConstraint;
        solve();
    }

    private void solve() {
        if (constraints.isEmpty()) return;
        difference = prepareVariables();
        System.out.println("Difference = " + difference);
        if (difference < 0) {
            System.out.println("Add constraints.");
            return;
        }
        if (difference == 0) {
            if (solveEquations(constraints, variables)) {
                store();
            } else {
                System.out.println("No solution have found.");
                restore();
            }
        } else {
            if (reduceConstraints()) {
                store();
            } else {
                restore();
                System.out.println("No solution have found with the reorganisation.");
                System.out.println("Removing last constraint: " + lastConstraint);
                constraints.remove(lastConstraint);
            }
        }
    }

    public void removeAutoConstraints() {
        canBeRemoved.clear();
        for (SketchConstraint sketchConstraint : constraints) {
            if (sketchConstraint.getStatus() == SketchConstraint.AUTO_CONSTRAINT)
                canBeRemoved.add(sketchConstraint);
        }
        for (SketchConstraint sketchConstraint : canBeRemoved) {
            constraints.remove(sketchConstraint);
        }
        System.out.println("Difference: " + prepareVariables());

    }

    private void store() {
        for (JoValue value : valueList) {
            value.store();
        }
        System.out.println("Valid solution stored in values.");
    }

    private void restore() {
        for (JoValue value : valueList) {
            value.restore();
        }
        System.out.println("Values have been restored.");

    }

    private boolean reduceConstraints() {
        List<JoPoint> toBeChecked = new ArrayList<>();
        canBeRemoved.clear();
        for (SketchConstraint c : constraints) {
            for (Object object : c.getComponents()) {
                if (object instanceof SketchGeometry) {
                    SketchGeometry sketchGeometry = (SketchGeometry) object;
                    toBeChecked.addAll(sketchGeometry.getPoints());
                }
            }
        }
        for (JoPoint point : toBeChecked) {
            for (SketchConstraint sketchConstraint : constraints) {
                if (sketchConstraint.getStatus() == SketchConstraint.AUTO_CONSTRAINT) {
                    if (sketchConstraint.getComponents().contains(point)) {
                        if (!canBeRemoved.contains(sketchConstraint)) {
                            canBeRemoved.add(sketchConstraint);
                        }
                    }
                }
            }
        }
        System.out.println("Can be remove: " + canBeRemoved.size());
        System.out.println("Must be remove: " + difference);
        if (canBeRemoved.size() < difference) {
            System.out.println("Too many constraints.");
            return false;
        }
        if (difference == 1) {
            SketchConstraint currentRemoved;
            for (int i = 0; i < canBeRemoved.size(); i++) {
                System.out.println("Remove " + i + ". auto constraint.");
                constraintsInSolver.clear();
                constraintsInSolver.addAll(constraints);
                currentRemoved = canBeRemoved.get(i);
                constraintsInSolver.remove(currentRemoved);
                if (solveEquations(constraintsInSolver, variables)) {
                    constraints.remove(currentRemoved);
                    return true;
                }
                restore();
            }
            return false;
        } else {
            System.out.println("TODO! :o");
        }
        System.out.println("Can not organise constraints.");
        return false;
    }

    private int prepareVariables() {
        valueList.clear();
        for (SketchConstraint constraint : constraints) {
            for (JoValue value : constraint.getValues()) {
                if (!valueList.contains(value)) valueList.add(value);
            }
        }
        variables.clear();
        for (JoValue value : valueList) {
            if (!variables.contains(value) && value.getStatus() == JoValue.VARIABLE) {
                variables.add(value);
            }
        }
        System.out.println(constraints.size() + " constraints");
        System.out.println(variables.size() + " variables");
        return constraints.size() - variables.size();
    }

    private boolean solveEquations(List<SketchConstraint> c, List<JoValue> v) {
        // Newton's method to solve systems of equations
        double[] fx = new double[c.size()];
        double[][] dfx = new double[c.size()][c.size()];
        RealMatrix coefficients;
        DecompositionSolver solver;
        RealVector constants;
        RealVector solution;

        for (int k = 0; k < MAX_ITERATIONS; k++) {
            for (int i = 0; i < c.size(); i++) {
                fx[i] = -1.0 * c.get(i).getFunctionValue();
                for (int j = 0; j < c.size(); j++) {
                    dfx[i][j] = c.get(i).getDerivative(v.get(j));
                }
            }
            coefficients = new Array2DRowRealMatrix(dfx, false);
            solver = new SingularValueDecomposition(coefficients).getSolver();
            constants = new ArrayRealVector(fx, false);
            solution = solver.solve(constants);
            boolean isSolved = true;
            for (int i = 0; i < solution.getDimension(); i++) {
                if (Math.abs(solution.getEntry(i)) > JoValue.DEFAULT_TOLERANCE) {
                    isSolved = false;
                }
            }
            if (isSolved) {
                System.out.println("Equations are solved in " + k + " steps.");
                return doubleCheck(c);
            }
            for (int i = 0; i < v.size(); i++) {
                v.get(i).set(v.get(i).get() + solution.getEntry(i));
            }
        }
        return false;
    }

    private boolean doubleCheck(List<SketchConstraint> c) {
        for (SketchConstraint constraint : c) {
            if (Math.abs(constraint.getFunctionValue()) > JoValue.DEFAULT_TOLERANCE) {
                System.out.println("Constrain with unsatisfied function!");
                System.out.println("Value: " + constraint.getFunctionValue());
                System.out.println("Constrain: " + constraint);
                return false;
            }
        }
        return true;
    }


    @Override
    public RegenerativeLink getRegenerativeLink() {
        return regenerativeLink;
    }

    @Override
    public void regenerate() throws Exception {
        for (Feature feature : references) {
            if (feature.getRegenerativeLink() != null) feature.getRegenerativeLink().regenerate();
        }
        regenerativeLink.regenerate();
        solve();
    }

    @Override
    public Feature getResult() {
        return this;
    }

    @Override
    public List<JoValue> getValues() {
        return valueList;
    }
}
