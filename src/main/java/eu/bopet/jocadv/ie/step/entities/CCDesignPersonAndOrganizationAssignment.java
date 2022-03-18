package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilIntIntSetOfInt;

public class CCDesignPersonAndOrganizationAssignment extends UtilIntIntSetOfInt {
    public CCDesignPersonAndOrganizationAssignment(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "CCDesignPersonAndOrganizationAssignment{" + super.toString() + "}";
    }
}
