package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.ie.step.util.UtilIntDouble;

public class Vector extends UtilIntDouble {

    public Vector(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "Vector{" + super.toString() + '}';
    }
}
