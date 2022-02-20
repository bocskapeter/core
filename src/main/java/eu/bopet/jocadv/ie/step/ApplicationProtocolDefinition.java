package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.ie.step.util.UtilStringIntInt;

public class ApplicationProtocolDefinition extends UtilStringIntInt {

    public ApplicationProtocolDefinition(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "ApplicationProtocolDefinition{" + super.toString() + '}';
    }
}
