package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilIntString;

public class DocumentReference extends UtilIntString {
    public DocumentReference(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "DocumentReference{" + super.toString() + "}";
    }
}