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

    private final List<Feature> references;
    private final List<SketchGeometry> geometries;
    private final List<SketchConstraint> constraints;
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
                    new JoValue(JoValue.USER, 0.0),
                    SketchConstraint.USER_DEFINED);
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
        }
        if (newGeometry instanceof JoArc) {
            JoArc arc = (JoArc) newGeometry;
            JoPoint point1 = arc.get1stPoint();
            JoPoint point2 = arc.get2ndPoint();
            JoPoint center = arc.getCircle().getSphere().getCenter();
            PointToPointDistance pointToPointDistance1 = new PointToPointDistance(
                    point1, center, arc.getRadius(), SketchConstraint.SYSTEM);
            PointToPointDistance pointToPointDistance2 = new PointToPointDistance(
                    point2, center, arc.getRadius(), SketchConstraint.SYSTEM);
            addConstraint(pointToPointDistance1);
            addConstraint(pointToPointDistance2);
        }
    }

    public void addConstraint(SketchConstraint newConstraint) {
        for (SketchConstraint constraint : constraints) {
            if (constraint.getClass().equals(newConstraint.getClass())) {
                if (constraint.getComponents().containsAll(newConstraint.getComponents())) {
                    System.out.println("Constraint already exists.");
                    return;
                }
            }
        }
        constraints.add(newConstraint);
        lastConstraint = newConstraint;
        solve();
    }

    private void solve() {
        if (constraints.isEmpty()) return;
        List<SketchConstraint> toBeDeleted = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            prepareVariables();

            System.out.println(constraints.size() + " constraints");
            System.out.println(variables.size() + " variables");

            if (constraints.size() == variables.size()) {
                break;
            }

            System.out.println("Constraints and variables mismatch.");

            if (constraints.size() > variables.size()) {
                System.out.println("Deleting auto constraints.");
                if (lastConstraint.getStatus() == SketchConstraint.AUTO_CONSTRAINT) {
                    constraints.remove(lastConstraint);
                    if (!toBeDeleted.contains(lastConstraint)){
                        toBeDeleted.add( lastConstraint);
                    }
                }
                //TODO remove auto constraints
            }
        }

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

        for (int k = 0; k < 10; k++) {
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
            if (constraint.getFunctionValue() > JoValue.DEFAULT_TOLERANCE) {
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
