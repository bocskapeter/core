package eu.bopet.jocadv.ie.step.util;

import eu.bopet.jocadv.ie.step.StepEntity;

import java.util.LinkedHashSet;
import java.util.Set;

public class UtilStringSetOfInt extends StepEntity {
    private String string;
    private Set<Integer> ids;

    public UtilStringSetOfInt(int id, String name, String attribute) {
        super(id, name);
        string = attribute.substring(0, attribute.indexOf(",(")).replace("'", "");
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
        return super.toString() +
                ", '" + string + '\'' + ", ids=" + ids + '}';
    }
}
