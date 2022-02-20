package eu.bopet.jocadv.ie.step.util;

import java.util.LinkedHashSet;
import java.util.Set;

public class UtilSetOfInt extends StepEntity {
    private Set<Integer> ids;

    public UtilSetOfInt(int id, String name, String attribute) {
        super(id, name);
        String bracket = attribute.substring(attribute.indexOf("(") + 1, attribute.lastIndexOf(")"))
                .replaceAll(" ", "");
        String[] values = bracket.split(",");
        ids = new LinkedHashSet<>();
        for (String value : values) {
            int anId = Integer.parseInt(value.substring(1));
            ids.add(anId);
        }
    }

    @Override
    public String toString() {
        return ids.toString();
    }
}
