package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntity;

public class ApprovalStatus extends StepEntity {
    public ApprovalStatus(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "ApprovalStatus{" + super.toString() + "}";
    }
}
