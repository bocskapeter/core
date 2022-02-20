package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.ie.step.util.UtilIntDouble;

public class CylindricalSurface extends UtilIntDouble {

    public CylindricalSurface(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "CylindricalSurface{" + super.toString() + '}';
    }
}
