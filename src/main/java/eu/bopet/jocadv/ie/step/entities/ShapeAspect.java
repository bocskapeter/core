package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringIntBoolean;

public class ShapeAspect extends UtilStringIntBoolean implements eu.bopet.jocadv.ie.step.shapeAspect.ShapeAspect {
    public ShapeAspect(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "ShapeAspect{" + super.toString() + "}";
    }
}
