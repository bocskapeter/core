package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfInt;

public class GeometricSet extends UtilSetOfInt {
    public GeometricSet(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "GeometricSet{" + super.toString() + "}";
    }
}
