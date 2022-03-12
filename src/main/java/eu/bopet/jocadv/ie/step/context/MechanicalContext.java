package eu.bopet.jocadv.ie.step.context;

import eu.bopet.jocadv.ie.step.util.UtilIntString;

public class MechanicalContext extends UtilIntString {
    public MechanicalContext(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "MechanicalContext{" + super.toString() + "}";
    }
}
