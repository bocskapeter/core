package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfIntInt;

import java.util.LinkedHashSet;
import java.util.Set;

public class AnnotationPlane extends UtilSetOfIntInt {
    private final Set<Integer> elements;

    public AnnotationPlane(int id, String name, String attribute) {
        super(id, name, attribute);
        elements = new LinkedHashSet<>();
        String[] parts = attribute.substring(attribute.lastIndexOf(",(") + 2).split(",");
        for (String s : parts) {
            elements.add(Integer.parseInt(s.replace("#", "")
                    .replace(")", "").replace("(", "")));
        }
    }

    @Override
    public String toString() {
        return "AnnotationPlane{" + super.toString() +
                ", elements=" + elements +
                '}';
    }
}
