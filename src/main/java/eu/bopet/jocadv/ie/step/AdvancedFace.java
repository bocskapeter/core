package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.ie.step.util.UtilSetOFIntIntBoolean;

public class AdvancedFace extends UtilSetOFIntIntBoolean {

    public AdvancedFace(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "AdvancedFace{" + super.toString() + '}';
    }
}
