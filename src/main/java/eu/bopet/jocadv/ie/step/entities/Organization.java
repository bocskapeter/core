package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringString;

public class Organization extends UtilStringString {
    public Organization(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "Organization{" + super.toString() + "}";
    }
}
