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
            for (String code : StepCode.TOLERANCES) {
                if (s.startsWith(code)) {
                    String attributes = s.substring(s.indexOf("(") + 1, s.lastIndexOf(")"));
                    switch (code) {
                        case StepCode.GEOMETRIC_TOLERANCE_WITH_DATUM_REFERENCE: {
                            GeometricToleranceWithDatumReference geometricToleranceWithDatumReference =
                                    new GeometricToleranceWithDatumReference(attributes);
                            tolerances.add(geometricToleranceWithDatumReference);
                            s = "";
                            continue;
                        }
                        case StepCode.POSITION_TOLERANCE: {
                            PositionTolerance positionTolerance = new PositionTolerance();
                            tolerances.add(positionTolerance);
                            s = "";
                            continue;
                        }
                        case StepCode.SURFACE_PROFILE_TOLERANCE: {
                            SurfaceProfileToleranceInSet surfaceProfileToleranceInSet = new SurfaceProfileToleranceInSet();
                            tolerances.add(surfaceProfileToleranceInSet);
                            s = "";
                            continue;
                        }
                        case StepCode.GEOMETRIC_TOLERANCE: {
                            GeometricTolerance geometricTolerance = new GeometricTolerance(attributes);
                            tolerances.add(geometricTolerance);
                            s = "";
                            continue;
                        }
                        case StepCode.UNEQUALLY_DISPOSED_GEOMETRIC_TOLERANCE: {
                            UnequallyDisposedGeometricTolerance unequallyDisposedGeometricTolerance =
                                    new UnequallyDisposedGeometricTolerance(attributes);
                            tolerances.add(unequallyDisposedGeometricTolerance);
                            s = "";
                            continue;
                        }
                        case StepCode.GEOMETRIC_TOLERANCE_WITH_MODIFIERS: {
                            GeometricToleranceWithModifiers geometricToleranceWithModifiers =
                                    new GeometricToleranceWithModifiers(attributes);
                            tolerances.add(geometricToleranceWithModifiers);
                            s = "";
                            continue;
                        }
                        default: {
                            System.out.println("Not processed tolerance: " + s);
                        }
                    }
                    System.out.println("Not processed item: " + s);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Tolerances{" + super.toString() +
                ", tolerances=" + tolerances +
                '}';
    }
}
