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

    private boolean edit;

    public JoSketch(JoCoSys coSys, RegenerativeLink regenerativeLink) {
        this.coSys = coSys;
        this.regenerativeLink = regenerativeLink;
        references = new ArrayList<>();
        geometries = new ArrayList<>();
        constraints = new ArrayList<>();
        edit = true;

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
        geometries.add(geometry);
        List<JoPoint> points = geometry.getPoints();
        for (JoPoint point : points) {
            PointToPlaneDistance pointToPlaneDistance = new PointToPlaneDistance(
                    coSys.getXy(),
                    point,
                    new JoValue(JoValue.USER, 0.0),
                    SketchConstraint.USER_DEFINED);
            addConstraint(pointToPlaneDistance);
        }
    }

    public void addConstraint(SketchConstraint newConstraint) {
        constraints.add(newConstraint);
        solve();
    }

    private void solve() {
        if (constraints.isEmpty()) return;
        List<JoValue> valueList = new ArrayList<>();
        for (SketchConstraint constraint : constraints) {
            valueList.addAll(constraint.getValues());
        }

        List<JoValue> variables = new ArrayList<>();
        for (JoValue value : valueList) {
            if (!variables.contains(value) && value.getStatus() == JoValue.VARIABLE) {
                variables.add(value);
            }
        }

        //DoF check
        int noConstraints = constraints.size();
        int noVariables = variables.size();
        if (noConstraints != noVariables) {

            System.out.println("Constraints and variables mismatch");
            System.out.println(noConstraints + " constraints");
            System.out.println(noVariables + " variables");

            if (noVariables > noConstraints) {
                //TODO add AUTO constraint
                List<SketchGeometry> constrainedGeometries = new ArrayList<>();
                for (SketchConstraint constraint : constraints) {
                    constrainedGeometries.addAll(constraint.getGeometries());
                }
                List<SketchGeometry> underConstrainedGeometries = new ArrayList<>();
                for (SketchGeometry geometry : geometries) {
                    int DoF = Collections.frequency(constrainedGeometries, geometry);
                    if (DoF < 3) {
                        underConstrainedGeometries.add(geometry);
                    }
                }
            } else {
                //TODO remove unnecessary constraints
            }
            return; // TODO delete
        }

        double[] fx = new double[constraints.size()];
        double[][] dfx = new double[constraints.size()][constraints.size()];

        RealMatrix coefficients;
        DecompositionSolver solver;
        RealVector constants;
        RealVector solution;

        for (int k = 0; k < 10; k++) {

            System.out.println("Iteration: " + k);

            for (int i = 0; i < constraints.size(); i++) {
                fx[i] = -1.0 * constraints.get(i).getFunctionValue();
                for (int j = 0; j < constraints.size(); j++) {
                    dfx[i][j] = constraints.get(i).getDerivative(variables.get(j));
                }
            }

            System.out.println("Fx: " + Arrays.toString(fx));
            for (double[] line : dfx) {
                System.out.println("dFx: " + Arrays.toString(line));
            }

            coefficients = new Array2DRowRealMatrix(dfx, false);
            solver = new SingularValueDecomposition(coefficients).getSolver();
            constants = new ArrayRealVector(fx, false);
            solution = solver.solve(constants);

            System.out.println("Solution (xn+1 - xn): " + solution.toString());

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
        regenerativeLink.regenerate();
        solve();
    }

    @Override
    public Feature getResult() {
        return this;
    }
}
