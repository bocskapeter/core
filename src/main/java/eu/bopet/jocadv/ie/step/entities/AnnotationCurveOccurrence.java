package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfIntInt;

public class AnnotationCurveOccurrence extends UtilSetOfIntInt {
    public AnnotationCurveOccurrence(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "AnnotationCurveOccurrence{" + super.toString() + "}";
    }
}
