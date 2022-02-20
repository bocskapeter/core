package eu.bopet.jocadv.ie.step.util;

public class UtilIntIntIntBoolean extends StepEntity {
    private int id1;
    private int id2;
    private int id3;
    private boolean aBoolean;

    public UtilIntIntIntBoolean(int id, String name, String attribute) {
        super(id, name);
        String[] values = attribute.split(",");
        String id1String = values[0].replace("#", "").replace("*", "");
        if (id1String.isEmpty()) id1 = -1;
        else id1 = Integer.parseInt(id1String);
        String id2String = values[1].replace("#", "").replace("*", "");
        if (id2String.isEmpty()) id2 = -1;
        else id2 = Integer.parseInt(id2String);
        id3 = Integer.parseInt(values[2].replace("#", ""));
        aBoolean = values[3].contains("T");
    }

    @Override
    public String toString() {
        return super.toString() + ", id1=" + id1 + ", id2=" + id2 + ", id3=" + id3 + ", T/F=" + aBoolean;
    }
}
