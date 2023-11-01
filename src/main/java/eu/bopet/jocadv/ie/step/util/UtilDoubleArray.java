package eu.bopet.jocadv.ie.step.util;

import eu.bopet.jocadv.ie.step.StepEntity;

import java.util.Arrays;

public class UtilDoubleArray extends StepEntity {
    private double[] doubles;

    public UtilDoubleArray(int id, String name, String attributes) {
        super(id, name);
        String substring = attributes;
        if (attributes.contains("(") && attributes.contains(")")) {
            substring = attributes.substring(attributes.indexOf("(") + 1, attributes.lastIndexOf(")"));
        }
        String[] values = substring.split(",");
        doubles = new double[values.length];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = Double.parseDouble(values[i]);
        }
    }

    public double[] getDoubles() {
        return doubles;
    }

    @Override
    public String toString() {
        return super.toString() + ", array=" + Arrays.toString(doubles);
    }
}
