package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilIntIntInt;

public class ApprovalPersonOrganization extends UtilIntIntInt {
    public ApprovalPersonOrganization(int id, String name, String attributes) {
        super(id, name, attributes);
    }

    @Override
    public String toString() {
        return "ApprovalPersonOrganization{" + super.toString() + "}";
    }
}
