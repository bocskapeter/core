package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfIntInt;

public class GeometricallyBoundedSurfaceShapeRepresentation extends UtilSetOfIntInt {
    public GeometricallyBoundedSurfaceShapeRepresentation(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "GeometricallyBoundedSurfaceShapeRepresentation{" + super.toString() + "}";
    }
}
