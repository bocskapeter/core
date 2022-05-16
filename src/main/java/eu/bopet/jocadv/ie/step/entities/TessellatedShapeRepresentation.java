package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfIntInt;

public class TessellatedShapeRepresentation extends UtilSetOfIntInt {
    public TessellatedShapeRepresentation(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "TessellatedShapeRepresentation{" + super.toString() + "}";
    }
}
