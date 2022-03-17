package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.StepEntityBase;

public class ApprovalRole extends StepEntityBase {
    public ApprovalRole(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "ApprovalRole{" + super.toString() + "}";
    }
}
