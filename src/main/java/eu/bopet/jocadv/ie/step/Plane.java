package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.ie.step.util.UtilInt;

public class Plane extends UtilInt {

    public Plane(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "Plane{" + super.toString() + '}';
    }
}
