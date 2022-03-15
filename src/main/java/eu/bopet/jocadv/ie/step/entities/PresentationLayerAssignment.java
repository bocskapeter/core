package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringSetOfInt;

public class PresentationLayerAssignment extends UtilStringSetOfInt {
    public PresentationLayerAssignment(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "PresentationLayerAssignment{" + super.toString() + "}";
    }
}
