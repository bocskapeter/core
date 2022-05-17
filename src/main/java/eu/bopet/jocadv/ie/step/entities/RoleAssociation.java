package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilIntInt;

public class RoleAssociation extends UtilIntInt {
    public RoleAssociation(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "RoleAssociation{" + super.toString() + "}";
    }
}
