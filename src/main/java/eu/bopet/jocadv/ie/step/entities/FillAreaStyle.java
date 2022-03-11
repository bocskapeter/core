package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfInt;

public class FillAreaStyle extends UtilSetOfInt {
    public FillAreaStyle(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "FillAreaStyle{" + super.toString() + "}";
    }
}
