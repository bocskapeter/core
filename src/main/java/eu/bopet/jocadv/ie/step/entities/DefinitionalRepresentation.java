package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfIntInt;

public class DefinitionalRepresentation extends UtilSetOfIntInt {

    public DefinitionalRepresentation(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "DefinitionalRepresentation{" + super.toString() + '}';
    }
}
