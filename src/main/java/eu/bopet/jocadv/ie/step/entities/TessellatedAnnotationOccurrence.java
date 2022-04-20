package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfIntInt;

public class TessellatedAnnotationOccurrence extends UtilSetOfIntInt {
    public TessellatedAnnotationOccurrence(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "TessellatedAnnotationOccurrence{" + super.toString() + "}";
    }
}
