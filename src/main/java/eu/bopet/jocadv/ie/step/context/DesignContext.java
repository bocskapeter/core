package eu.bopet.jocadv.ie.step.context;

import eu.bopet.jocadv.ie.step.util.UtilIntString;

public class DesignContext extends UtilIntString {
    public DesignContext(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "DesignContext{" + super.toString() + "}";
    }
}
