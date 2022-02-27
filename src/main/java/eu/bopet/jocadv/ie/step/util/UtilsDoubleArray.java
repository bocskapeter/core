package eu.bopet.jocadv.ie.step.util;

import java.util.Arrays;

public class UtilsDoubleArray extends StepEntityBase {
    private double[] doubles;

    public UtilsDoubleArray(int id, String name, String attributes) {
        super(id, name);
        String substring = attributes.substring(attributes.indexOf("(") + 1, attributes.lastIndexOf(")"));
        String[] values = substring.split(",");
        doubles = new double[values.length];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = Double.parseDouble(values[i]);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", array=" + Arrays.toString(doubles);
    }
}
