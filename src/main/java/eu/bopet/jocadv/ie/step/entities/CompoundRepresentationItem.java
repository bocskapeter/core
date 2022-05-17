package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfInt;

public class CompoundRepresentationItem extends UtilSetOfInt {
    public CompoundRepresentationItem(int id, String name, String attribute) {
        super(id, name, attribute.substring(attribute.indexOf("(") + 1));
    }

    @Override
    public String toString() {
        return "CompoundRepresentationItem{" + super.toString() + "}";
    }
}
