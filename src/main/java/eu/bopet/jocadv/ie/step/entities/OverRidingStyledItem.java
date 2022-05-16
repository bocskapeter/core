package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfIntInt;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class OverRidingStyledItem extends UtilSetOfIntInt {
    private final int overRiddenStyle;

    public OverRidingStyledItem(int id, String name, String attribute) {
        super(id, name, attribute);
        String s = attribute.substring(attribute.lastIndexOf(",") + 1)
                .replace("#", "");
        if (isNumeric(s)) {
            overRiddenStyle = Integer.parseInt(s);
        } else
            overRiddenStyle = -1;
    }

    @Override
    public String toString() {
        return "OverRidingStyledItem{" + super.toString() +
                ", overRiddenStyle=" + overRiddenStyle +
                '}';
    }
}
