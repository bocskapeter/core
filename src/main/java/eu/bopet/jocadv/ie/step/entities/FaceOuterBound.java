package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilInt;

public class FaceOuterBound extends UtilInt {
    private boolean orientation;

    public FaceOuterBound(int id, String name, String attribute) {
        super(id, name, attribute.substring(0, attribute.indexOf(",")));
        orientation = attribute.substring(attribute.lastIndexOf(",")).contains("T");
    }

    @Override
    public String toString() {
        return "FaceOuterBound{" + super.toString() +
                ", orientation=" + orientation +
                '}';
    }
}
