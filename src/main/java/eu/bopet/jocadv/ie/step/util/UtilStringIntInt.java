package eu.bopet.jocadv.ie.step.util;

import eu.bopet.jocadv.ie.step.StepEntityBase;

public class UtilStringIntInt extends StepEntityBase {
    private String string;
    private int id1;
    private int id2;

    public UtilStringIntInt(int id, String name, String attribute) {
        super(id, name);
        String[] values = attribute.split(",");
        this.string = values[0].replace("'", "").stripLeading();
        this.id1 = Integer.parseInt(values[1].replace("#", "").replace(" ", ""));
        this.id2 = Integer.parseInt(values[2].replace("#", "").replace(" ", ""));
    }

    @Override
    public String toString() {
        return super.toString() + ", '" + string + "', id1=" + id1 + ", id2=" + id2;
    }
}
