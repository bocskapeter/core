package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilIntInt;

public class ToleranceValue extends UtilIntInt {
    public ToleranceValue(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "ToleranceValue{" + super.toString() + "}";
    }
}
