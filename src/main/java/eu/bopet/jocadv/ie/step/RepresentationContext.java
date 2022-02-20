package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.ie.step.util.UtilString;

public class RepresentationContext extends UtilString {

    public RepresentationContext(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "RepresentationContext{" + super.toString() + '}';
    }
}
