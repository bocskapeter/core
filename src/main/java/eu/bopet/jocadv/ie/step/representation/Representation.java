package eu.bopet.jocadv.ie.step.representation;

import eu.bopet.jocadv.ie.step.util.UtilSetOfIntInt;

public class Representation extends UtilSetOfIntInt {
    public Representation(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "Representation{" + super.toString() + "}";
    }
}
