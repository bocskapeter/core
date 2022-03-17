package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilIntString;

public class Approval extends UtilIntString {
    public Approval(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "Approval{" + super.toString() + "}";
    }
}
