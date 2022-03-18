package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilIntInt;

public class CoordinatedUniversalTimeOffset extends UtilIntInt {
    private AheadOrBehind aheadOrBehind;

    public CoordinatedUniversalTimeOffset(int id, String name, String attribute) {
        super(id, name, attribute);
        String s = attribute.substring(attribute.lastIndexOf(",") + 1);
        aheadOrBehind = AheadOrBehind.valueOf(s.replace(".", ""));
    }

    @Override
    public String toString() {
        return "CoordinatedUniversalTimeOffset{" + super.toString() +
                ", aheadOrBehind=" + aheadOrBehind +
                '}';
    }
}
