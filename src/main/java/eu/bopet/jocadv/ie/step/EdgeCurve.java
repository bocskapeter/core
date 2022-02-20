package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.ie.step.util.UtilIntIntIntBoolean;

public class EdgeCurve extends UtilIntIntIntBoolean {

    public EdgeCurve(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "EdgeCurve{" + super.toString() + '}';
    }
}
