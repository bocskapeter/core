package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilIntInt;

public class ApprovalDateTime extends UtilIntInt {
    public ApprovalDateTime(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "ApprovalDateTime{" + super.toString() + "}";
    }
}
