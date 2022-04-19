package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilIntInt;

public class MappedItem extends UtilIntInt {
    public MappedItem(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "MappedItem{" + super.toString() + "}";
    }
}
