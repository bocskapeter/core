package eu.bopet.jocadv.ie.step;

import java.util.Arrays;

public class Direction extends StepEntity {
    private double[] coordinates;

    public Direction(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public static Direction getInstance(int id, String name, String attributes) {
        String substring = attributes.substring(attributes.indexOf("(") + 1, attributes.lastIndexOf(")"));
        String[] values = substring.split(",");
        double[] coordinates = new double[values.length];
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i] = Double.parseDouble(values[i]);
        }
        Direction direction = new Direction(coordinates);
        direction.setId(id);
        direction.setName(name);
        return direction;
    }

    @Override
    public String toString() {
        return "Direction{" + super.toString() +
                " coordinates=" + Arrays.toString(coordinates) +
                '}';
    }
}
