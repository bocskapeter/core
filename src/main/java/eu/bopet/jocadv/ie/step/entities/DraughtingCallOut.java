package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfInt;

public class DraughtingCallOut extends UtilSetOfInt {
    public DraughtingCallOut(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "DraughtingCallOut{" + super.toString() + "}";
    }
}
