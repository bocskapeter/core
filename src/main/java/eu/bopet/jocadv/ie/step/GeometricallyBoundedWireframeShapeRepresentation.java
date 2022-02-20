package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.ie.step.util.UtilSetOfIntInt;

public class GeometricallyBoundedWireframeShapeRepresentation extends UtilSetOfIntInt {

    public GeometricallyBoundedWireframeShapeRepresentation(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "GeometricallyBoundedWireframeShapeRepresentation{" + super.toString() + '}';
    }
}
