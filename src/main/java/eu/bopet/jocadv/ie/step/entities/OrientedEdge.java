package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilIntIntIntBoolean;

public class OrientedEdge extends UtilIntIntIntBoolean {
    public OrientedEdge(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "OrientedEdge{" + super.toString() + '}';
    }
}