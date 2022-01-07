package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.constraints.feature.RegenerativeLink;
import eu.bopet.jocadv.core.constraints.sketch.PointToPlaneDistance;
import eu.bopet.jocadv.core.constraints.sketch.PointToPointDistance;
import eu.bopet.jocadv.core.constraints.sketch.SketchConstraint;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.FeatureBase;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoCoSys;
import eu.bopet.jocadv.core.features.vector.JoValue;
import org.apache.commons.math3.linear.*;

import java.util.ArrayList;
import java.util.List;

public class JoSketch extends FeatureBase implements Feature, RegenerativeLink {

    private static final int MAX_ITERATIONS = 31;

    private final List<Feature> references;
    private final List<SketchGeometry> geometries;
    private final List<SketchConstraint> constraints;
    private final List<JoPoint> points;
    private SketchConstraint lastConstraint;
    private final JoCoSys coSys;
    private final RegenerativeLink regenerativeLink;
    private final List<JoValue> valueList;
    private final List<JoValue> variables;
    private boolean edit;

    public JoSketch(JoCoSys coSys, RegenerativeLink regenerativeLink) {
        this.coSys = coSys;
        this.regenerativeLink = regenerativeLink;
        references = new ArrayList<>();
        geometries = new ArrayList<>();
        constraints = new ArrayList<>();
        points = new ArrayList<>();
        valueList = new ArrayList<>();
        variables = new ArrayList<>();
        edit = false;
        edit();
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
        for (Object o : components) {
            if (o instanceof Feature && !geometries.contains(o)) {
                Feature feature = (Feature) o;
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
        if (!prepareConstraints()) return;
        solveEquations();
        if (doubleCheck()) {
            for (JoValue value : valueList) {
                value.store();
            }
            System.out.println("Valid solution stored in values");
        } else {
            System.out.println("No valid solution has been found");
        }
    }

    private boolean prepareConstraints() {
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            prepareVariables();

            System.out.println(constraints.size() + " constraints");
            System.out.println(variables.size() + " variables");

            if (constraints.size() == variables.size()) {
                return true;
            }

            System.out.println("Constraints and variables mismatch.");

            if (constraints.size() < variables.size()) {
                System.out.println("Add more constraints.");
                break;
            }

            if (constraints.size() > variables.size()) {
                System.out.println("Deleting auto constraints.");
                List<SketchConstraint> toBeRemoved = new ArrayList<>();
                List<JoPoint> toBeChecked = new ArrayList<>();
                for (Object o : lastConstraint.getComponents()) {
                    if (o instanceof SketchGeometry) {
                        SketchGeometry sketchGeometry = (SketchGeometry) o;
                        toBeChecked.addAll(sketchGeometry.getPoints());
                    }
                }
                for (JoPoint point : toBeChecked) {
                    for (SketchConstraint sketchConstraint : constraints) {
                        if (sketchConstraint.getStatus() == SketchConstraint.AUTO_CONSTRAINT) {
                            if (sketchConstraint.getComponents().contains(point)) {
                                if (!toBeRemoved.contains(sketchConstraint)) {
                                    toBeRemoved.add(sketchConstraint);
                                }
                            }
                        }
                    }
                }
                System.out.println("Can be remove: " + toBeRemoved.size());
                if (toBeRemoved.size() <= 0) {
                    break;
                }
                int difference = constraints.size() - variables.size();
                for (int j = 0; j < difference; j++) {
                    SketchConstraint toRemove = toBeRemoved.get(j);
                    constraints.remove(toRemove);
                    System.out.println("ToRemove: " + toRemove);
                }
            }
        }
        System.out.println("Can not organise constraints.");
        return false;
    }

    private void prepareVariables() {
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
    }

    private void solveEquations() {
        // Newton's method to solve systems of equations
        double[] fx = new double[constraints.size()];
        double[][] dfx = new double[constraints.size()][constraints.size()];
        RealMatrix coefficients;
        DecompositionSolver solver;
        RealVector constants;
        RealVector solution;

        for (int k = 0; k < MAX_ITERATIONS; k++) {
            for (int i = 0; i < constraints.size(); i++) {
                fx[i] = -1.0 * constraints.get(i).getFunctionValue();
                for (int j = 0; j < constraints.size(); j++) {
                    dfx[i][j] = constraints.get(i).getDerivative(variables.get(j));
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
                return;
            }

            for (int i = 0; i < variables.size(); i++) {
                variables.get(i).set(variables.get(i).get() + solution.getEntry(i));
            }
            System.out.println("x: " + variables);
        }
    }

    private boolean doubleCheck() {
        for (SketchConstraint constraint : constraints) {
            if (Math.abs(constraint.getFunctionValue()) > JoValue.DEFAULT_TOLERANCE) {
                System.out.println("A Constrain with unsatisfied function value of: " + constraint.getFunctionValue());
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
    public void regenerate() {
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
