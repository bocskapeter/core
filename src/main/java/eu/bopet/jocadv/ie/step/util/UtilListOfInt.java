package eu.bopet.jocadv.ie.step.util;

import eu.bopet.jocadv.ie.step.StepEntity;

import java.util.ArrayList;
import java.util.List;

public class UtilListOfInt extends StepEntity {
    private List<Integer> list;

    public UtilListOfInt(int id, String name, String attribute) {
        super(id, name);
        String cleaned = attribute.replace(" ", "");
        String substring = cleaned
                .substring(cleaned.indexOf("(") + 1, cleaned.lastIndexOf(")"));
        String[] values = substring.split(",");
        list = new ArrayList<>();
        for (String value : values) {
            int anId = Integer.parseInt(value.replace("#", ""));
            list.add(anId);
        }
    }

    public List<Integer> getList() {
        return list;
    }

    @Override
    public String toString() {
        return super.toString() + ", list=" + list.toString();
    }
}
