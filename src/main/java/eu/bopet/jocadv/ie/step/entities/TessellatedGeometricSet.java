package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfInt;

public class TessellatedGeometricSet extends UtilSetOfInt {
    public TessellatedGeometricSet(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "TessellatedGeometricSet{" + super.toString() + "}";
    }
}
