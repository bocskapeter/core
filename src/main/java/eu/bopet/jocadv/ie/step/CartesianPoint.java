package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.ie.step.util.UtilsDoubleArray;

public class CartesianPoint extends UtilsDoubleArray {

    public CartesianPoint(int id, String name, String attributes) {
        super(id, name, attributes);
    }

    @Override
    public String toString() {
        return "CartesianPoint{" + super.toString() + '}';
    }
}
