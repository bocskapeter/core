package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntity;

public class ApprovalRole extends StepEntity {
    public ApprovalRole(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "ApprovalRole{" + super.toString() + "}";
    }
}
