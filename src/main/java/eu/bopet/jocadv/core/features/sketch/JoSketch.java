package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.constraints.feature.RegenerativeLink;
import eu.bopet.jocadv.core.constraints.sketch.PointToPlaneDistance;
import eu.bopet.jocadv.core.constraints.sketch.SketchConstraint;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.FeatureBase;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoCoSys;
import eu.bopet.jocadv.core.features.vector.JoValue;
import org.apache.commons.math3.linear.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JoSketch extends FeatureBase implements Feature, RegenerativeLink {

    private final List<Feature> references;
    private final List<SketchGeometry> geometries;
    private final List<SketchConstraint> constraints;
    private final JoCoSys coSys;
    private final RegenerativeLink regenerativeLink;
    private List<JoValue> valueList;
    private List<JoValue> variables;
    private SketchConstraint lastConstraint;

    private boolean edit;

    public JoSketch(JoCoSys coSys, RegenerativeLink regenerativeLink) {
        this.coSys = coSys;
        this.regenerativeLink = regenerativeLink;
        references = new ArrayList<>();
        geometries = new ArrayList<>();
        constraints = new ArrayList<>();
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


    public void addGeometry(SketchGeometry geometry) {
        if (geometries.contains(geometry)) return;
        geometries.add(geometry);
        for (JoValue value : geometry.getValues()) {
            value.setStatus(JoValue.VARIABLE);
        }
        if (geometry instanceof JoPoint){
            JoPoint point = (JoPoint) geometry;
            boolean alreadyOnPlane = false;
            for (SketchConstraint constraint : constraints) {
                if (constraint instanceof PointToPlaneDistance
                        && constraint.getGeometries().contains(point)
                        && constraint.getGeometries().contains(coSys.getXy())) {
                    alreadyOnPlane = true;
                }
            }
            if (!alreadyOnPlane) {
                PointToPlaneDistance pointToPlaneDistance = new PointToPlaneDistance(
                        coSys.getXy(),
                        point,
                        new JoValue(JoValue.USER, 0.0),
                        SketchConstraint.USER_DEFINED);
                addConstraint(pointToPlaneDistance);
            }
            return;
        }
        List<JoPoint> points = geometry.getPoints();
        for (JoPoint point : points) {
            if (!geometries.contains(point)) {
                addGeometry(point);
            }
        }
    }

    public void addConstraint(SketchConstraint newConstraint) {
        constraints.add(newConstraint);
        lastConstraint = newConstraint;
        solve();
    }

    private void solve() {
        if (constraints.isEmpty()) return;
        do {
            prepareVariables();
            System.out.println(constraints.size() + " constraints");
            System.out.println(variables.size() + " variables");
        } while (doDoFCheck());
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

    private boolean doubleCheck() {
        for (SketchConstraint constraint : constraints) {
            if (constraint.getFunctionValue() > JoValue.DEFAULT_TOLERANCE){
                System.out.println("This constrain is still unsatisfied with function value: " + constraint.getFunctionValue());
                return false;
            }
        }
        return true;
    }

    private void prepareVariables() {
        valueList = new ArrayList<>();
        for (SketchConstraint constraint : constraints) {
            valueList.addAll(constraint.getValues());
        }
        variables = new ArrayList<>();
        for (JoValue value : valueList) {
            if (!variables.contains(value) && value.getStatus() == JoValue.VARIABLE) {
                variables.add(value);
            }
        }
    }

    private boolean doDoFCheck() {
        if (constraints.size() != variables.size()) {

            System.out.println("Constraints and variables mismatch");

            if (variables.size() > constraints.size()) {
                System.out.println();
                List<SketchGeometry> constrainedGeometries = new ArrayList<>();
                for (SketchConstraint constraint : constraints) {
                    for (SketchGeometry geometry : constraint.getGeometries()) {
                        if (!constrainedGeometries.contains(geometry))
                            constrainedGeometries.add(geometry);
                    }
                }
                List<SketchGeometry> underConstrainedGeometries = new ArrayList<>();
                for (SketchGeometry geometry : geometries) {
                    int DoF = Collections.frequency(constrainedGeometries, geometry);
                    if (DoF == 1 && geometry instanceof JoPoint) {
                        JoPoint point = (JoPoint) geometry;
                        // X
                        JoValue distanceX = new JoValue(JoValue.AUTO, 0.0);
                        PointToPlaneDistance pointToPlaneDistanceYZ = new PointToPlaneDistance(
                                this.coSys.getYz(), point, distanceX, SketchConstraint.AUTO_CONSTRAINT);
                        double realDistanceX = pointToPlaneDistanceYZ.getFunctionValue();
                        distanceX.set(realDistanceX);
                        constraints.add(pointToPlaneDistanceYZ);
                        // Y
                        JoValue distanceY = new JoValue(JoValue.AUTO, 0.0);
                        PointToPlaneDistance pointToPlaneDistanceXZ = new PointToPlaneDistance(
                                this.coSys.getXz(), point, distanceY, SketchConstraint.AUTO_CONSTRAINT);
                        double realDistanceY = pointToPlaneDistanceXZ.getFunctionValue();
                        distanceY.set(realDistanceY);
                        constraints.add(pointToPlaneDistanceXZ);
                        return true;
                    }
                }
            } else if (variables.size() < constraints.size()) {
                List<SketchGeometry> lastGeometries = lastConstraint.getGeometries();
                for (SketchGeometry geometry : lastGeometries) {
                    for (SketchConstraint constraint : constraints) {
                        if (constraint.getStatus() == SketchConstraint.AUTO_CONSTRAINT
                                && constraint.getGeometries().contains(geometry)) {
                            constraints.remove(constraint);
                            return true;
                        }
                    }
                }
                for (SketchGeometry geometry : lastGeometries) {
                    List<JoPoint> points = geometry.getPoints();
                    for (JoPoint point : points){
                        for (SketchConstraint constraint : constraints){
                            if (constraint.getStatus() == SketchConstraint.AUTO_CONSTRAINT
                                    && constraint.getGeometries().contains(point)){
                                constraints.remove(constraint);
                                return true;
                            }
                        }
                    }
                }
                //TODO no AUTO constraint to remove user should remove unnecessary constraints
            }
        }
        return false;
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
}
