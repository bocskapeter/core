package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringIntBoolean;

public class CompositeGroupShapeAspect extends UtilStringIntBoolean {
    public CompositeGroupShapeAspect(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "CompositeGroupShapeAspect{" + super.toString() + "}";
    }
}
