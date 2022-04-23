package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilIntInt;

public class PlusMinusTolerance extends UtilIntInt {
    public PlusMinusTolerance(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "PlusMinusTolerance{" + super.toString() + "}";
    }
}
