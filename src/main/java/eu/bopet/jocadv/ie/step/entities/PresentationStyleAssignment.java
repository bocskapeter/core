package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntityBase;

import java.util.LinkedHashSet;
import java.util.Set;

public class PresentationStyleAssignment extends StepEntityBase {
    private Set<Integer> styles;

    public PresentationStyleAssignment(int id, String name, String attribute) {
        super(id, name);
        styles = new LinkedHashSet<>();
        String[] styleString = attribute.replace("(", "").replace(")", "")
                .split(",");
        for (String s : styleString) {
            styles.add(Integer.parseInt(s.replace("#", "")));
        }
    }

    @Override
    public String toString() {
        return "PresentationStyleAssignment{" + super.toString() +
                ", styles=" + styles +
                '}';
    }
}
