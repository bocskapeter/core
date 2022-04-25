package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilInt;

public class NameAttribute extends UtilInt {
    public NameAttribute(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "NameAttribute{" + super.toString() + "}";
    }
}