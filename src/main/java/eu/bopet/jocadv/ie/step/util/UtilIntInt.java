package eu.bopet.jocadv.ie.step.util;

import eu.bopet.jocadv.ie.step.StepEntityBase;

public class UtilIntInt extends StepEntityBase {
    private int id1;
    private int id2;

    public UtilIntInt(int id, String name, String attribute) {
        super(id, name);
        String[] values = attribute.split(",");
        this.id1 = Integer.parseInt(values[0].replace("#", ""));
        this.id2 = Integer.parseInt(values[1].replace("#", ""));
    }

    public int get1st() {
        return id1;
    }

    public int get2nd() {
        return id2;
    }

    @Override
    public String toString() {
        return super.toString() + ", 1=" + id1 + ", 2=" + id2;
    }
}
