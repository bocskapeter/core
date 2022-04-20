package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringIntIntInt;

public class GeometricItemSpecificUsage extends UtilStringIntIntInt {
    public GeometricItemSpecificUsage(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "GeometricItemSpecificUsage{" + super.toString() + "}";
    }
}
