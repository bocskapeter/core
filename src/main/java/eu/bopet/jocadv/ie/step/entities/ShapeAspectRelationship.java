package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringIntInt;

public class ShapeAspectRelationship extends UtilStringIntInt {
    public ShapeAspectRelationship(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "ShapeAspectRelationship{" + super.toString() + "}";
    }
}
