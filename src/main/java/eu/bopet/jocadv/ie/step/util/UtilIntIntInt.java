package eu.bopet.jocadv.ie.step.util;

public class UtilIntIntInt extends StepEntity {
    private int id1;
    private int id2;
    private int id3;

    public UtilIntIntInt(int id, String name, String attributes) {
        super(id, name);
        String[] values = attributes.split(",");
        this.id1 = Integer.parseInt(values[0].substring(1));
        this.id2 = Integer.parseInt(values[1].substring(1));
        this.id3 = Integer.parseInt(values[2].substring(1));
    }

    @Override
    public String toString() {
        return "id1=" + id1 + ", id2=" + id2 + ", id3=" + id3;
    }
}
