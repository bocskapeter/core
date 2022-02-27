package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilIntDoubleDouble;

public class ConicalSurface extends UtilIntDoubleDouble {

    public ConicalSurface(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "ConicalSurface{" + super.toString() + '}';
    }
}
