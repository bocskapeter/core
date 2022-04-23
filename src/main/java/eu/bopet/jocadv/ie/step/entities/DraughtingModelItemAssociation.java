package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringIntIntInt;

public class DraughtingModelItemAssociation extends UtilStringIntIntInt {
    public DraughtingModelItemAssociation(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "DraughtingModelItemAssociation{" + super.toString() + '}';
    }
}
