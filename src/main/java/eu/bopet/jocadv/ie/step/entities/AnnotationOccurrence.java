package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfIntInt;

public class AnnotationOccurrence extends UtilSetOfIntInt {
    public AnnotationOccurrence(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "AnnotationOccurrence{" + super.toString() + "}";
    }
}
