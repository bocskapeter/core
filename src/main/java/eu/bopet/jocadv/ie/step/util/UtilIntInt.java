package eu.bopet.jocadv.ie.step.util;

public class UtilIntInt extends StepEntity {
    private int id1;
    private int id2;

    public UtilIntInt(int id, String name, String attribute) {
        super(id, name);
        String[] values = attribute.split(",");
        this.id1 = Integer.parseInt(values[0].substring(1));
        this.id2 = Integer.parseInt(values[1].substring(1));
    }

    @Override
    public String toString() {
        return super.toString() + ", id1=" + id1 + ", id2=" + id2;
    }
}
