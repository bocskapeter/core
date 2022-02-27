package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilIntDoubleDouble;

public class Ellipse extends UtilIntDoubleDouble {
    public Ellipse(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "Ellipse{" + super.toString() + '}';
    }
}
