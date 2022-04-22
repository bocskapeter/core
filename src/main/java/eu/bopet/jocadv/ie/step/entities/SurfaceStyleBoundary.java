package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilInt;

public class SurfaceStyleBoundary extends UtilInt {
    public SurfaceStyleBoundary(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "SurfaceStyleBoundary{" + super.toString() + "}";
    }
}
