package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilIntInt;

public class PersonAndOrganization extends UtilIntInt {
    public PersonAndOrganization(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "PersonAndOrganization{" + super.toString() + "}";
    }
}
