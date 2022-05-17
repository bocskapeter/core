package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringString;

public class Document extends UtilStringString {
    private int type;

    public Document(int id, String name, String attribute) {
        super(id, name, attribute);
        type = Integer.parseInt(attribute.substring(attribute.lastIndexOf(",") + 1)
                .replace("#", ""));
    }

    @Override
    public String toString() {
        return "Document{" + super.toString() +
                ", type=" + type +
                '}';
    }
}
