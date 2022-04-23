package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilInt;

public class IdAttribute extends UtilInt {
    public IdAttribute(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "IdAttribute{" + super.toString() + "}";
    }
}
