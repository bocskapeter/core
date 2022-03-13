package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilInt;

public class VertexLoop extends UtilInt {
    public VertexLoop(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "VertexLoop{" + super.toString() + "}";
    }
}
