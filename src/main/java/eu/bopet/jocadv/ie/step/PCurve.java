package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.ie.step.util.UtilIntInt;

public class PCurve extends UtilIntInt {
    public PCurve(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "PCurve{" + super.toString() + '}';
    }
}
