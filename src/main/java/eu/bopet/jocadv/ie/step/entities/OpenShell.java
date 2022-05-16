package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilSetOfInt;

public class OpenShell extends UtilSetOfInt {
    public OpenShell(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "OpenShell{" + super.toString() + "}";
    }
}
