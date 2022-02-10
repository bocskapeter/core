package eu.bopet.jocadv.ie.step;

import java.util.Arrays;

public class Direction extends StepEntity{
    private double[] coordinates;

    public Direction(double[] coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Direction{" +  super.toString() +
                " coordinates=" + Arrays.toString(coordinates) +
                '}';
    }
}
