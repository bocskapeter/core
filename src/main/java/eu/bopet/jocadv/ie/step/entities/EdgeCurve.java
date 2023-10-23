package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepFeature;
import eu.bopet.jocadv.ie.step.StepLink;
import eu.bopet.jocadv.ie.step.util.UtilIntIntIntBoolean;

public class EdgeCurve extends UtilIntIntIntBoolean implements StepLink {

    public EdgeCurve(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "EdgeCurve{" + super.toString() + '}';
    }

    @Override
    public void generateJoFeature(StepFeature feature) throws Exception {

    }

    @Override
    public void regenerate() throws Exception {

    }
}
