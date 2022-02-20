package eu.bopet.jocadv.ie.step.util;

import java.util.LinkedHashSet;
import java.util.Set;

public class UtilSetOfIntInt extends StepEntity {
    private Set<Integer> set;
    private int id;

    public UtilSetOfIntInt(int id, String name, String attribute) {
        super(id, name);
        String substring = attribute.substring(attribute.indexOf("(") + 1, attribute.lastIndexOf(")"));
        String[] items = substring.split(",");
        this.set = new LinkedHashSet<>();
        for (String item : items) {
            this.set.add(Integer.parseInt(item.substring(1)));
        }
        String last = attribute.substring(attribute.lastIndexOf(",") + 1);
        this.id = Integer.parseInt(last.substring(1));
    }

    @Override
    public String toString() {
        return "(" + set + "), id=" + id;
    }
}
