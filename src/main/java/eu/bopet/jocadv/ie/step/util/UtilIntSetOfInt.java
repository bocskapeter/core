package eu.bopet.jocadv.ie.step.util;

import eu.bopet.jocadv.ie.step.StepEntityBase;

import java.util.LinkedHashSet;
import java.util.Set;

public class UtilIntSetOfInt extends StepEntityBase {
    private int id;
    private Set<Integer> ids;

    public UtilIntSetOfInt(int id, String name, String attribute) {
        super(id, name);
        this.id = Integer.parseInt(attribute.substring(1, attribute.indexOf(",")));
        String bracket = attribute.substring(attribute.indexOf("(") + 1, attribute.lastIndexOf(")"))
                .replaceAll(" ", "");

        String[] values = bracket.split(",");
        ids = new LinkedHashSet<>();
        for (String value : values) {
            if (!value.isEmpty()) {
                int anId = Integer.parseInt(value.replace("#", ""));
                ids.add(anId);
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", id=" + id + ", set=" + ids;
    }
}
