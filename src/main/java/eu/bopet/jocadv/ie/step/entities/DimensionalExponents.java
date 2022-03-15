package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilDoubleArray;

public class DimensionalExponents extends UtilDoubleArray {
    public DimensionalExponents(int id, String name, String attributes) {
        super(id, name, attributes);
    }

    @Override
    public String toString() {
        return "DimensionalExponents{" + super.toString() + "}";
    }
}
