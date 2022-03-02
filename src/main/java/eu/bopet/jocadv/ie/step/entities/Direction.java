package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilDoubleArray;

public class Direction extends UtilDoubleArray {

    public Direction(int id, String name, String attributes) {
        super(id, name, attributes);
    }

    @Override
    public String toString() {
        return "Direction{" + super.toString() + '}';
    }
}