package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringString;

public class GeneralProperty extends UtilStringString {
    public GeneralProperty(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "GeneralProperty{" + super.toString() + "}";
    }
}
