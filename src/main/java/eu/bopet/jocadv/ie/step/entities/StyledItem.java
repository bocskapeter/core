package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntityBase;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class StyledItem extends StepEntityBase {
    private Set<Integer> styles;
    private int item;

    public StyledItem(int id, String name, String attribute) {
        super(id, name);
        styles = new LinkedHashSet<>();
        String[] parts = attribute.split(Pattern.quote("),"));
        String[] styleStrings = parts[0].replace("#", "").split(",");
        for (String s : styleStrings) {
            styles.add(Integer.parseInt(s.replace("(", "")));
        }
        item = Integer.parseInt(parts[1].replace("#", ""));
    }

    @Override
    public String toString() {
        return "StyledItem{" + super.toString() +
                ", styles=" + styles +
                ", item=" + item +
                '}';
    }
}
