package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfInt;

public class GeometricCurveSet extends UtilSetOfInt {
    public GeometricCurveSet(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "GeometricCurveSet{" + super.toString() + "}";
    }
}
