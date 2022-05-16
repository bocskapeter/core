package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfInt;

public class VolumeUnit extends UtilSetOfInt {
    public VolumeUnit(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "VolumeUnit{" + super.toString() + "}";
    }
}
