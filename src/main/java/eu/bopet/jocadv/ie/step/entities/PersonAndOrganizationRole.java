package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.StepEntityBase;

public class PersonAndOrganizationRole extends StepEntityBase {
    public PersonAndOrganizationRole(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "PersonAndOrganizationRole{" + super.toString() + "}";
    }
}