package eu.bopet.jocadv.ie.step.tolerance;

public class GeometricToleranceWithDefinedAreaUnit implements Tolerance {
    private AreaUnitType areaUnitType;
    private int secondUnitSize;

    public GeometricToleranceWithDefinedAreaUnit(String attribute) {
        String[] parts = attribute.split(",");
        areaUnitType = AreaUnitType.valueOf(parts[0].replace(".", ""));
        secondUnitSize = Integer.parseInt(parts[1].replace("#", ""));
    }

    @Override
    public String toString() {
        return "GeometricToleranceWithDefinedAreaUnit{" +
                "areaUnitType=" + areaUnitType +
                ", secondUnitSize=" + secondUnitSize +
                '}';
    }
}
