package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntityBase;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class PresentationStyleAssignment extends StepEntityBase {
    private Set<Integer> styles;

    public PresentationStyleAssignment(int id, String name, String attribute) {
        super(id, name);
        styles = new LinkedHashSet<>();
        String[] styleStrings = attribute.replace("(", "").replace(")", "")
                .split(",");
        for (String s : styleStrings) {
            if (!s.contains("NULL_STYLE")) {
                String styleString = s.replace("#", "");
                if (isNumeric(styleString))
                    styles.add(Integer.parseInt(styleString));
            }

        }
    }

    @Override
    public String toString() {
        return "PresentationStyleAssignment{" + super.toString() +
                ", styles=" + styles +
                '}';
    }
}
