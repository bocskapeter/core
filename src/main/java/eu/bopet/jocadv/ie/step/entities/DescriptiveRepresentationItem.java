package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilString;

public class DescriptiveRepresentationItem extends UtilString {
    public DescriptiveRepresentationItem(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "DescriptiveRepresentationItem{" + super.toString() + "}";
    }
}
