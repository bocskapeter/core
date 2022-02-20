package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.ie.step.util.UtilIntInt;

public class ShapeDefinitionRepresentation extends UtilIntInt {

    public ShapeDefinitionRepresentation(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "ShapeDefinitionRepresentation{" + super.toString() + '}';
    }
}
