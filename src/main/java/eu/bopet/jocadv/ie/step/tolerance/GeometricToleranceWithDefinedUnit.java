package eu.bopet.jocadv.ie.step.tolerance;

public class GeometricToleranceWithDefinedUnit implements Tolerance {
    private int unitSize;

    public GeometricToleranceWithDefinedUnit(String attribute) {
        unitSize = Integer.parseInt(attribute.replace("#", ""));
    }

    @Override
    public String toString() {
        return "GeometricToleranceWithDefinedUnit{" +
                "unitSize=" + unitSize +
                '}';
    }
}
