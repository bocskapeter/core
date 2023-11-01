package eu.bopet.jocadv.ie.step.util;

import eu.bopet.jocadv.ie.step.StepEntity;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class UtilIntIntInt extends StepEntity {
    private int id1;
    private int id2;
    private int id3;

    public UtilIntIntInt(int id, String name, String attributes) {
        super(id, name);
        String[] values = attributes.replace("#", "").split(",");
        id1 = Integer.parseInt(values[0]);
        id2 = -1;
        if (isNumeric(values[1])) id2 = Integer.parseInt(values[1]);
        id3 = -1;
        if (isNumeric(values[2])) id3 = Integer.parseInt(values[2]);
    }

    public int getId1() {
        return id1;
    }

    public int getId2() {
        return id2;
    }

    public int getId3() {
        return id3;
    }

    @Override
    public String toString() {
        return super.toString() + ", id1=" + id1 + ", id2=" + id2 + ", id3=" + id3;
    }
}
