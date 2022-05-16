package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfInt;

public class ShellBasedSurfaceModel extends UtilSetOfInt {
    public ShellBasedSurfaceModel(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "ShellBasedSurfaceModel{" + super.toString() + "}";
    }
}
