package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringIntInt;

public class ShapeRepresentationRelationship extends UtilStringIntInt {
    public ShapeRepresentationRelationship(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "ShapeRepresentationRelationship{" + super.toString() + "}";
    }
}
