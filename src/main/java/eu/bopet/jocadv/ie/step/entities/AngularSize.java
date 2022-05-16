package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilIntString;

public class AngularSize extends UtilIntString {
    private AngleRelator angleRelator;

    public AngularSize(int id, String name, String attribute) {
        super(id, name, attribute);
        angleRelator = AngleRelator.valueOf(attribute.substring(attribute.lastIndexOf(",") + 1)
                .replace(".", ""));
    }

    @Override
    public String toString() {
        return "AngularSize{" + super.toString() +
                ", angleRelator=" + angleRelator +
                '}';
    }
}
