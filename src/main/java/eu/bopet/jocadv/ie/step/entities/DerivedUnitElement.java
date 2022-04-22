package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilIntDouble;

public class DerivedUnitElement extends UtilIntDouble {
    public DerivedUnitElement(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "DerivedUnitElement{" + super.toString() + "}";
    }
}
