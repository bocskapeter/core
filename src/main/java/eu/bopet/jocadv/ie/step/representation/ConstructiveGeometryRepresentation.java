package eu.bopet.jocadv.ie.step.representation;

import eu.bopet.jocadv.ie.step.util.UtilSetOfIntInt;

public class ConstructiveGeometryRepresentation extends UtilSetOfIntInt {
    public ConstructiveGeometryRepresentation(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "ConstructiveGeometryRepresentation{" + super.toString() + "}";
    }
}
