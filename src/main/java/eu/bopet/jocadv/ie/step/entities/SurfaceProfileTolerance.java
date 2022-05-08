package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringIntInt;

public class SurfaceProfileTolerance extends UtilStringIntInt {
    public SurfaceProfileTolerance(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "SurfaceProfileTolerance{" + super.toString() + "}";
    }
}
