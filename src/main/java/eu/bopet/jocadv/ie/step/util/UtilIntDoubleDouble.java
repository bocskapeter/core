package eu.bopet.jocadv.ie.step.util;

public class UtilIntDoubleDouble extends StepEntityBase {
    private int id;
    private double double1;
    private double double2;

    public UtilIntDoubleDouble(int id, String name, String attribute) {
        super(id, name);
        String[] values = attribute.split(",");
        this.id = Integer.parseInt(values[0].substring(1));
        double1 = Double.parseDouble(values[1]);
        double2 = Double.parseDouble(values[2]);
    }

    @Override
    public String toString() {
        return super.toString() + ", id=" + id + ", 1st=" + double1 + ", 2nd=" + double2;
    }
}
