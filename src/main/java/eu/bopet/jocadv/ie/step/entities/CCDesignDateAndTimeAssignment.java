package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilIntIntSetOfInt;

public class CCDesignDateAndTimeAssignment extends UtilIntIntSetOfInt {
    public CCDesignDateAndTimeAssignment(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "CCDesignDateAndTimeAssignment{" + super.toString() + "}";
    }
}
