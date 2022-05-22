package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfIntInt;

public class TessellatedSolid extends UtilSetOfIntInt {
    public TessellatedSolid(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "TessellatedSolid{" + super.toString() + "}";
    }
}
