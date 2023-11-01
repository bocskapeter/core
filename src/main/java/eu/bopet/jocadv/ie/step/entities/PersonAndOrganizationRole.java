package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntity;

public class PersonAndOrganizationRole extends StepEntity {
    public PersonAndOrganizationRole(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "PersonAndOrganizationRole{" + super.toString() + "}";
    }
}
