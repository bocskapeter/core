package eu.bopet.jocadv.ie.step;

import java.util.Arrays;

public class CartesianPoint extends StepEntity {
    private double[] coordinates;

    public CartesianPoint(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public static CartesianPoint getInstance(int id, String name, String attributes) {
        String substring = attributes.substring(attributes.indexOf("(") + 1, attributes.lastIndexOf(")"));
        String[] values = substring.split(",");
        double[] coordinates = new double[values.length];
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i] = Double.parseDouble(values[i]);
        }
        CartesianPoint point = new CartesianPoint(coordinates);
        point.setId(id);
        point.setName(name);
        return point;
    }

    @Override
    public String toString() {
        return "CartesianPoint{" + super.toString() +
                " coordinates=" + Arrays.toString(coordinates) +
                '}';
    }
}
