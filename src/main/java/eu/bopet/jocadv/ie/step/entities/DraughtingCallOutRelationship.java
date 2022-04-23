package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringIntInt;

public class DraughtingCallOutRelationship extends UtilStringIntInt {
    public DraughtingCallOutRelationship(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "DraughtingCallOutRelationship{" + super.toString() + "}";
    }
}
