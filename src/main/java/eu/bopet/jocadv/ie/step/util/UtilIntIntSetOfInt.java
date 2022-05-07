package eu.bopet.jocadv.ie.step.util;

import eu.bopet.jocadv.ie.step.StepEntityBase;

import java.util.LinkedHashSet;
import java.util.Set;

public class UtilIntIntSetOfInt extends StepEntityBase {
    private int id1;
    private int id2;
    private Set<Integer> set;

    public UtilIntIntSetOfInt(int id, String name, String attribute) {
        super(id, name);
        String[] values = attribute.split(",");
        this.id1 = Integer.parseInt(values[0].substring(1));
        this.id2 = Integer.parseInt(values[1].substring(1));
        set = new LinkedHashSet<>();
        for (int i = 2; i < values.length; i++) {
            set.add(Integer.parseInt(values[i]
                    .replace("#", "")
                    .replace("(", "")
                    .replace(")", "")));
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                ", id1=" + id1 +
                ", id2=" + id2 +
                ", set=" + set;
    }
}
