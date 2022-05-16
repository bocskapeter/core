package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilListOfInt;

public class CompositeCurve extends UtilListOfInt {
    private boolean selfIntersect;

    public CompositeCurve(int id, String name, String attribute) {
        super(id, name, attribute);
        selfIntersect = attribute.substring(attribute.lastIndexOf(",")).contains("T");
    }

    @Override
    public String toString() {
        return "CompositeCurve{" + super.toString() +
                ", selfIntersect=" + selfIntersect +
                '}';
    }
}
