package eu.bopet.jocadv.ie.step.representation;

import eu.bopet.jocadv.ie.step.util.UtilStringIntInt;

public class RepresentationRelationship extends UtilStringIntInt {
    public RepresentationRelationship(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "RepresentationRelationship{" + super.toString() + "}";
    }
}
