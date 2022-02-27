package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfInt;

public class ClosedShell extends UtilSetOfInt {

    public ClosedShell(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "ClosedShell{" + super.toString() + '}';
    }
}
