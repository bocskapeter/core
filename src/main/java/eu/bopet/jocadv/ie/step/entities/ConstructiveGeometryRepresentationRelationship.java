package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringIntInt;

public class ConstructiveGeometryRepresentationRelationship extends UtilStringIntInt {
    public ConstructiveGeometryRepresentationRelationship(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "ConstructiveGeometryRepresentationRelationship{" + super.toString() + "}";
    }
}
