package eu.bopet.jocadv.ie.step.util;

import eu.bopet.jocadv.ie.step.StepEntityBase;

import java.util.LinkedHashSet;
import java.util.Set;

public class UtilSetOfIntInt extends StepEntityBase {
    private final Set<Integer> set;
    private final int id;

    public UtilSetOfIntInt(int id, String name, String attribute) {
        super(id, name);
        String substring = attribute.substring(attribute.indexOf("(") + 1, attribute.indexOf(")"));
        String[] items = substring.split(",");
        this.set = new LinkedHashSet<>();
        for (String item : items) {
            this.set.add(Integer.parseInt(item.replace("#", "").replace(" ", "")
                    .replace(")", "")));
        }
        String last = attribute.substring(attribute.indexOf(")") + 2);
        if (last.contains(",")) {
            this.id = Integer.parseInt(last.substring(1, last.indexOf(",")).replace("#", ""));
        } else {
            this.id = Integer.parseInt(last.substring(1).replace("#", ""));
        }

    }

    @Override
    public String toString() {
        return super.toString() + ", set=" + set + ", id=" + id;
    }
}
