package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfInt;

public class AreaUnit extends UtilSetOfInt {
    public AreaUnit(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "AreaUnit{" + super.toString() + "}";
    }
}
