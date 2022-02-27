package eu.bopet.jocadv.ie.step.util;

import java.util.ArrayList;
import java.util.List;

public class UtilListOfInt extends StepEntityBase {
    private List<Integer> list;

    public UtilListOfInt(int id, String name, String attribute) {
        super(id, name);
        String substring = attribute.substring(attribute.indexOf("(") + 1, attribute.lastIndexOf(")"));
        String[] values = substring.split(",");
        list = new ArrayList<>();
        for (String value : values) {
            int anId = Integer.parseInt(value.substring(1));
            list.add(anId);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", list=" + list.toString();
    }
}
