package eu.bopet.jocadv.ie.step.surface;

import eu.bopet.jocadv.ie.step.util.UtilIntDouble;

public class SphericalSurface extends UtilIntDouble {
    public SphericalSurface(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "SphericalSurface{" + super.toString() + "}";
    }
}
