package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepFeature;
import eu.bopet.jocadv.ie.step.StepLink;
import eu.bopet.jocadv.ie.step.util.UtilSetOfIntInt;

public class DefinitionalRepresentation extends UtilSetOfIntInt implements StepLink {

    public DefinitionalRepresentation(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "DefinitionalRepresentation{" + super.toString() + '}';
    }

    @Override
    public void generateJoFeature(StepFeature feature) throws Exception {
        //TODO
    }

    @Override
    public void regenerate() throws Exception {

    }
}
