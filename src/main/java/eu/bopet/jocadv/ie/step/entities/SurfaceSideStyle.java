package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfInt;

public class SurfaceSideStyle extends UtilSetOfInt {
    public SurfaceSideStyle(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "SurfaceSideStyle{" + super.toString() + "}";
    }
}
