package eu.bopet.jocadv.ie.step.util;

import eu.bopet.jocadv.ie.step.StepEntity;

public class UtilIntDoubleDouble extends StepEntity {
    private int anInt;
    private double double1;
    private double double2;

    public UtilIntDoubleDouble(int anInt, String name, String attribute) {
        super(anInt, name);
        String[] values = attribute.split(",");
        this.anInt = Integer.parseInt(values[0].substring(1));
        double1 = Double.parseDouble(values[1]);
        double2 = Double.parseDouble(values[2]);
    }

    public int getAnInt() {
        return anInt;
    }

    public double getDouble1() {
        return double1;
    }

    public double getDouble2() {
        return double2;
    }

    @Override
    public String toString() {
        return super.toString() + ", id=" + anInt + ", 1st=" + double1 + ", 2nd=" + double2;
    }
}
