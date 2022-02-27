package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfInt;

public class RepresentationsInContext extends UtilSetOfInt {

    public RepresentationsInContext(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "RepresentationsInContext{" + super.toString() + '}';
    }
}
