package eu.bopet.jocadv.ie.step.util;

import eu.bopet.jocadv.ie.step.StepEntityBase;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.apache.commons.lang3.StringUtils.isNumeric;

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
        String last = attribute.substring(attribute.indexOf(")") + 1)
                .replace(" ", "").replace("#", "");
        if (isNumeric(last)) {
            this.id = Integer.parseInt(last);
        } else {
            this.id = -1;
        }

    }

    @Override
    public String toString() {
        return super.toString() + ", set=" + set + ", id=" + id;
    }
}
