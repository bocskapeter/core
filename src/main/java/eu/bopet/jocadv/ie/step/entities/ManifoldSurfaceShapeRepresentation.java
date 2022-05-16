package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfIntInt;

public class ManifoldSurfaceShapeRepresentation extends UtilSetOfIntInt {
    public ManifoldSurfaceShapeRepresentation(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "ManifoldSurfaceShapeRepresentation{" + super.toString() + "}";
    }
}
