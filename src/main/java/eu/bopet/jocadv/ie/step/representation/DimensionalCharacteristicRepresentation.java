package eu.bopet.jocadv.ie.step.representation;

import eu.bopet.jocadv.ie.step.util.UtilIntInt;

public class DimensionalCharacteristicRepresentation extends UtilIntInt {
    public DimensionalCharacteristicRepresentation(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "DimensionalCharacteristicRepresentation{" + super.toString() + "}";
    }
}
