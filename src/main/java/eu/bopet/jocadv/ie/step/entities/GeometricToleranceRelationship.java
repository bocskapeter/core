package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringIntInt;

public class GeometricToleranceRelationship extends UtilStringIntInt {
    public GeometricToleranceRelationship(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "GeometricToleranceRelationship{" + super.toString() + "}";
    }
}
