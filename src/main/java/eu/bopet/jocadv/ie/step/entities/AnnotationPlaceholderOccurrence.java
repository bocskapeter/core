package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfIntInt;

public class AnnotationPlaceholderOccurrence extends UtilSetOfIntInt {
    private AnnotationPlaceholderOccurrenceRole role;
    private double lineSpacing;

    public AnnotationPlaceholderOccurrence(int id, String name, String attribute) {
        super(id, name, attribute);
        String firstPart = attribute.substring(0, attribute.lastIndexOf(","));
        role = AnnotationPlaceholderOccurrenceRole.valueOf(firstPart.substring(firstPart.lastIndexOf(",") + 1)
                .replace(".", ""));
        lineSpacing = Double.parseDouble(attribute.substring(attribute.lastIndexOf(",") + 1));
    }

    @Override
    public String toString() {
        return "AnnotationPlaceholderOccurrence{" + super.toString() +
                ", role=" + role +
                ", lineSpacing=" + lineSpacing +
                '}';
    }
}
