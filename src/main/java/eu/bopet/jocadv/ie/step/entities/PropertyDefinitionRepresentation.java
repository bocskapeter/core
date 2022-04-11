package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilIntInt;

public class PropertyDefinitionRepresentation extends UtilIntInt {
    public PropertyDefinitionRepresentation(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "PropertyDefinitionRepresentation{" + super.toString() + "}";
    }
}
