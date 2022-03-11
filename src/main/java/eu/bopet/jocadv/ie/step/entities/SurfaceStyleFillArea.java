package eu.bopet.jocadv.ie.step.entities;


import eu.bopet.jocadv.ie.step.util.UtilInt;

public class SurfaceStyleFillArea extends UtilInt {
    public SurfaceStyleFillArea(int id, String name, String attribute) {
        super(id, name, attribute);
    }
    @Override
    public String toString() {
        return "SurfaceStyleFillArea{" + super.toString() + "}";
    }
}
