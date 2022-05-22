package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfIntInt;

public class TessellatedShell extends UtilSetOfIntInt {
    public TessellatedShell(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "TessellatedShell{" + super.toString() + "}";
    }
}
