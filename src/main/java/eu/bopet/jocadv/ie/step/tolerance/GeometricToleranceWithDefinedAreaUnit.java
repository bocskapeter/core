package eu.bopet.jocadv.ie.step.tolerance;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class GeometricToleranceWithDefinedAreaUnit implements Tolerance {
    private AreaUnitType areaUnitType;
    private int secondUnitSize;

    public GeometricToleranceWithDefinedAreaUnit(String attribute) {
        String[] parts = attribute.split(",");
        areaUnitType = AreaUnitType.valueOf(parts[0].replace(".", ""));
        String s = parts[1].replace("#", "");
        if (isNumeric(s)) {
            secondUnitSize = Integer.parseInt(parts[1].replace("#", ""));
        } else {
            secondUnitSize = -1;
        }

    }

    @Override
    public String toString() {
        return "GeometricToleranceWithDefinedAreaUnit{" +
                "areaUnitType=" + areaUnitType +
                ", secondUnitSize=" + secondUnitSize +
                '}';
    }
}
