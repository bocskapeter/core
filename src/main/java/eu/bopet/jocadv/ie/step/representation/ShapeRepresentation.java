package eu.bopet.jocadv.ie.step.representation;

import eu.bopet.jocadv.ie.step.util.UtilSetOfIntInt;

public class ShapeRepresentation extends UtilSetOfIntInt {
    public ShapeRepresentation(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "ShapeRepresentation{" + super.toString() + "}";
    }
}
