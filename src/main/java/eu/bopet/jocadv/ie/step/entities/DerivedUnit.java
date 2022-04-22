package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfInt;

public class DerivedUnit extends UtilSetOfInt {
    public DerivedUnit(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "DerivedUnit{" + super.toString() + "}";
    }
}
