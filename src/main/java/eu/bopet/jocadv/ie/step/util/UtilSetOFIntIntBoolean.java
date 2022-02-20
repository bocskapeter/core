package eu.bopet.jocadv.ie.step.util;

import java.util.LinkedHashSet;
import java.util.Set;

public class UtilSetOFIntIntBoolean extends StepEntity {
    private Set<Integer> set;
    private int id;
    private boolean aBoolean;

    public UtilSetOFIntIntBoolean(int id, String name, String attribute) {
        super(id, name);
        String substring = attribute.substring(attribute.indexOf("(") + 1, attribute.lastIndexOf(")"));
        String[] values = substring.split(",");
        this.set = new LinkedHashSet<>();
        for (String value : values) {
            this.set.add(Integer.parseInt(value.substring(1)));
        }
        String[] rest = (attribute.substring(attribute.indexOf(")") + 1)).split(",");
        this.id = Integer.parseInt(rest[1].substring(1));
        this.aBoolean = rest[2].contains("T");
    }

    @Override
    public String toString() {
        return "{" + set + ", " + id + ", " + aBoolean + '}';
    }
}
