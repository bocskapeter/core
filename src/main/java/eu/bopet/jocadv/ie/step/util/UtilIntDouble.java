package eu.bopet.jocadv.ie.step.util;

public class UtilIntDouble extends StepEntityBase {
    private int id;
    private double aDouble;

    public UtilIntDouble(int id, String name, String attribute) {
        super(id, name);
        String[] values = attribute.split(",");
        this.id = Integer.parseInt(values[0].substring(1));
        this.aDouble = Double.parseDouble(values[1]);
    }

    public int get1st() {
        return id;
    }

    public double get2nd() {
        return aDouble;
    }

    @Override
    public String toString() {
        return super.toString() + ", id=" + id + ", value=" + aDouble;
    }
}
