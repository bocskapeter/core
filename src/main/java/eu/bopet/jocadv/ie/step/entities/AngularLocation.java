package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringIntInt;

public class AngularLocation extends UtilStringIntInt {
    private AngleRelator angleSelection;

    public AngularLocation(int id, String name, String attribute) {
        super(id, name, attribute);
        String last = attribute.substring(attribute.lastIndexOf(",") + 1).replace(".", "");
        angleSelection = AngleRelator.valueOf(last);
    }

    @Override
    public String toString() {
        return "AngularLocation{" + super.toString() +
                ", angleSelection=" + angleSelection +
                '}';
    }
}
