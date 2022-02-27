package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilInt;

public class VertexPoint extends UtilInt {

    public VertexPoint(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "VertexPoint{" + super.toString() + '}';
    }
}
