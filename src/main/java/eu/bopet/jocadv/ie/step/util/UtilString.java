package eu.bopet.jocadv.ie.step.util;

import eu.bopet.jocadv.ie.step.StepEntity;

public class UtilString extends StepEntity {
    String string;

    public UtilString(int id, String name, String attribute) {
        super(id, name);
        string = attribute.replace("'", "").stripLeading();
    }

    @Override
    public String toString() {
        return super.toString() + ", '" + string + "'";
    }
}
