package eu.bopet.jocadv.ie.step;

import java.util.LinkedHashSet;
import java.util.Set;

public class UtilSetOfIntInt extends StepEntity {
    private Set<Integer> set;
    private int id;

    public UtilSetOfIntInt(Set<Integer> set, int id) {
        this.set = set;
        this.id = id;
    }

    public static UtilSetOfIntInt getInstance(int id, String name, String attribute) {
        String substring = attribute.substring(attribute.indexOf("(") + 1, attribute.lastIndexOf(")"));
        String[] items = substring.split(",");
        Set<Integer> itemIds = new LinkedHashSet<>();
        for (String item : items) {
            itemIds.add(Integer.parseInt(item.substring(1)));
        }
        String last = attribute.substring(attribute.lastIndexOf(",") + 1);
        int contextId = Integer.parseInt(last.substring(1));
        UtilSetOfIntInt utilSetOfIntInt = new UtilSetOfIntInt(itemIds, contextId);
        utilSetOfIntInt.setId(id);
        utilSetOfIntInt.setName(name);
        return utilSetOfIntInt;
    }

    @Override
    public String toString() {
        return "(" + set + "), " + id;
    }
}
