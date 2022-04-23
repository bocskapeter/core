package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilIntString;

public class DimensionalSize extends UtilIntString {
    public DimensionalSize(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "DimensionalSize{" + super.toString() + "}";
    }
}
