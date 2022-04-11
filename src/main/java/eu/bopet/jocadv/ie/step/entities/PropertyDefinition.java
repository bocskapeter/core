package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringInt;

public class PropertyDefinition extends UtilStringInt {
    public PropertyDefinition(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "PropertyDefinition{" + super.toString() + "}";
    }
}
