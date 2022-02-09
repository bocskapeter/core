package eu.bopet.jocadv.ie.step;

import java.util.Arrays;

public class CartesianPoint extends StepEntity{
    private double[] coordinates;

    public CartesianPoint(double[] coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "CartesianPoint{" + super.toString() +
                " coordinates=" + Arrays.toString(coordinates) +
                '}';
    }
}
