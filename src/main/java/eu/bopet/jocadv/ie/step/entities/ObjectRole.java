package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilString;

public class ObjectRole extends UtilString {
    public ObjectRole(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "ObjectRole{" + super.toString() + "}";
    }
}
