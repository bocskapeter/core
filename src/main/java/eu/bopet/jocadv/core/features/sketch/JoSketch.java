package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.constraints.Constraint;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.Geometry;
import eu.bopet.jocadv.core.features.datums.JoCoSys;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.datums.vector.JoValue;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.linear.SingularValueDecomposition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JoSketch extends Feature {

    private final List<Geometry> references;
    private final List<Geometry> geometries;
    private final List<Constraint> constraints;
    private JoPlane sketchPlane;
    private JoCoSys coSys;

    private boolean edit;

    public JoSketch(JoPlane sketchPlane) {
        this.sketchPlane = sketchPlane;
        references = new ArrayList<>();
        geometries = new ArrayList<>();
        constraints = new ArrayList<>();
        edit = true;
    }

    public void edit() {
        if (edit) return;
        for (Geometry geometry : geometries) {
            for (JoValue value : geometry.getValues()) {
                value.setStatus(JoValue.VARIABLE);
            }
        }
        edit = true;
    }

    public void close() {
        if (edit) {
            for (Geometry geometry : geometries) {
                for (JoValue value : geometry.getValues()) {
                    value.setStatus(JoValue.FIX);
                }
            }
        }
        edit = false;
    }


    public void addGeometry(Geometry geometry) {
        geometries.add(geometry);
    }

    public void addConstraint(Constraint newConstraint) {
        constraints.add(newConstraint);
        List<Geometry> geometries = newConstraint.getGeometries();
        for (Geometry geometry : geometries) {
            if (!geometries.contains(geometry)) {
                if (!references.contains(geometry)) {
                    references.add(geometry);
                }
            }
        }
        solve();
    }

    private void solve() {
        List<JoValue> valueList = new ArrayList<>();
        for (Constraint constraint : constraints) {
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

//            if (noVariables > noConstraints) {
//                //TODO add AUTO constraint
//                List<Geometry> constrainedGeometries = new ArrayList<>();
//                for (Constraint constraint : constraints) {
//                    constrainedGeometries.addAll(constraint.getGeometries());
//                }
//                List<Geometry> underConstrainedGeometries = new ArrayList<>();
//                for (Geometry geometry : geometries) {
//                    int DoF = Collections.frequency(constrainedGeometries, geometry);
//                    if (DoF < 3) {
//                        underConstrainedGeometries.add(geometry);
//                    }
//                }
//
//            } else {
//                //TODO remove unnecessary constraints
//            }
//            return; // TODO delete
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
}
