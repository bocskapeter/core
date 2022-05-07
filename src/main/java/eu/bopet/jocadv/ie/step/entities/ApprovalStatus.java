package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntityBase;

public class ApprovalStatus extends StepEntityBase {
    public ApprovalStatus(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "ApprovalStatus{" + super.toString() + "}";
    }
}
