package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringIntInt;

public class FeatureForDatumTargetRelationship extends UtilStringIntInt {
    public FeatureForDatumTargetRelationship(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "FeatureForDatumTargetRelationship{" + super.toString() + "}";
    }
}
