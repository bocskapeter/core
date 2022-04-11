package eu.bopet.jocadv.ie.step.representation;

import eu.bopet.jocadv.ie.step.util.UtilIntInt;

public class RepresentationMap extends UtilIntInt {
    public RepresentationMap(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "RepresentationMap{" + super.toString() + "}";
    }
}
