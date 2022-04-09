package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringIntInt;

public class MechanicalDesignAndDraughtingRelationship extends UtilStringIntInt {
    public MechanicalDesignAndDraughtingRelationship(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "MechanicalDesignAndDraughtingRelationship{" + super.toString() + "}";
    }
}
