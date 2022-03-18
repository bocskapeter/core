package eu.bopet.jocadv.ie.step.util;

public class UtilIntIntInt extends StepEntityBase {
    private int id1;
    private int id2;
    private int id3;

    public UtilIntIntInt(int id, String name, String attributes) {
        super(id, name);
        String[] values = attributes.replace("#", "").split(",");
        this.id1 = Integer.parseInt(values[0]);
        this.id2 = Integer.parseInt(values[1]);
        this.id3 = Integer.parseInt(values[2]);
    }

    @Override
    public String toString() {
        return super.toString() + ", id1=" + id1 + ", id2=" + id2 + ", id3=" + id3;
    }
}
