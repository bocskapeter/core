package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfInt;

public class Polyline extends UtilSetOfInt {
    public Polyline(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "Polyline{" + super.toString() + "}";
    }
}
