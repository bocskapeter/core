package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilInt;

public class FillAreaStyleColour extends UtilInt {

    public FillAreaStyleColour(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "FillAreaStyleColour{" + super.toString() + "}";
    }
}
