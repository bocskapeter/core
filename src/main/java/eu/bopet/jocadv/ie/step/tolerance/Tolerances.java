package eu.bopet.jocadv.ie.step.tolerance;

import eu.bopet.jocadv.ie.step.StepEntityBase;
import eu.bopet.jocadv.ie.step.util.StepCode;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Tolerances extends StepEntityBase {
    private Set<Tolerance> tolerances;

    public Tolerances(int id, String name, String set) {
        super(id, name);
        tolerances = new LinkedHashSet<>();
        List<String> toleranceListString = StepEntityBase.getSets(set);
        for (String s : toleranceListString) {
            String attributes = s.substring(s.indexOf("(") + 1, s.lastIndexOf(")"));
            if (s.startsWith(StepCode.GEOMETRIC_TOLERANCE_WITH_DATUM_REFERENCE)) {
                GeometricToleranceWithDatumReference geometricToleranceWithDatumReference =
                        new GeometricToleranceWithDatumReference(attributes);
                tolerances.add(geometricToleranceWithDatumReference);
                continue;
            }
            if (s.startsWith(StepCode.POSITION_TOLERANCE)) {
                PositionTolerance positionTolerance = new PositionTolerance();
                tolerances.add(positionTolerance);
                continue;
            }
            if (s.startsWith(StepCode.SURFACE_PROFILE_TOLERANCE)) {
                SurfaceProfileToleranceInSet surfaceProfileToleranceInSet = new SurfaceProfileToleranceInSet();
                tolerances.add(surfaceProfileToleranceInSet);
                continue;
            }
            if (s.startsWith(StepCode.UNEQUALLY_DISPOSED_GEOMETRIC_TOLERANCE)) {
                UnequallyDisposedGeometricTolerance unequallyDisposedGeometricTolerance =
                        new UnequallyDisposedGeometricTolerance(attributes);
                tolerances.add(unequallyDisposedGeometricTolerance);
                continue;
            }
            if (s.startsWith(StepCode.GEOMETRIC_TOLERANCE_WITH_MODIFIERS)) {
                GeometricToleranceWithModifiers geometricToleranceWithModifiers =
                        new GeometricToleranceWithModifiers(attributes);
                tolerances.add(geometricToleranceWithModifiers);
                continue;
            }
            if (s.startsWith(StepCode.GEOMETRIC_TOLERANCE)) {
                GeometricTolerance geometricTolerance = new GeometricTolerance(attributes);
                tolerances.add(geometricTolerance);
                continue;
            }
            if (s.startsWith(StepCode.LINE_PROFILE_TOLERANCE)) {
                LineProfileTolerance lineProfileTolerance = new LineProfileTolerance();
                tolerances.add(lineProfileTolerance);
                continue;
            }
            if (s.startsWith(StepCode.PERPENDICULARITY_TOLERANCE)) {
                PerpendicularityTolerance perpendicularityTolerance = new PerpendicularityTolerance();
                tolerances.add(perpendicularityTolerance);
                continue;
            }
            System.out.println("Not processed tolerance: " + s);
        }
    }

    @Override
    public String toString() {
        return "Tolerances{" + super.toString() +
                ", tolerances=" + tolerances +
                '}';
    }
}
