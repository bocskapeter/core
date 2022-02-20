package eu.bopet.jocadv.ie.step.util;

public class UtilIntIntIntBoolean extends StepEntity {
    private int id1;
    private int id2;
    private int id3;
    private boolean aBoolean;

    public UtilIntIntIntBoolean(int id, String name, String attribute) {
        super(id, name);
        String[] values = attribute.split(",");
        id1 = Integer.parseInt(values[0].substring(1));
        id2 = Integer.parseInt(values[1].substring(1));
        id3 = Integer.parseInt(values[2].substring(1));
        aBoolean = values[3].contains("T");
    }

    @Override
    public String toString() {
        return "1=" + id1 + ", 2=" + id2 + ", 3=" + id3 + ", T/F=" + aBoolean;
    }
}
