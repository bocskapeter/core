package eu.bopet.jocadv.ie.step.representation;

import eu.bopet.jocadv.ie.step.util.UtilSetOfIntInt;

public class ShapeDimensionRepresentation extends UtilSetOfIntInt {
    public ShapeDimensionRepresentation(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "ShapeDimensionRepresentation{" + super.toString() + "}";
    }
}
