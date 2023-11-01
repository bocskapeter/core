package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.basic.curve.JoPCurve;
import eu.bopet.jocadv.ie.step.StepEntity;
import eu.bopet.jocadv.ie.step.StepFeature;
import eu.bopet.jocadv.ie.step.StepLink;
import eu.bopet.jocadv.ie.step.util.UtilIntInt;

public class PCurve extends UtilIntInt implements StepLink {
    public PCurve(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "PCurve{" + super.toString() + '}';
    }

    @Override
    public void generateJoFeature(StepFeature feature) throws Exception {
        StepEntity basis = feature.getStepEntityByID(super.get1st());
        StepEntity reference = feature.getStepEntityByID(super.get2nd());
        if (!feature.getFeatureMap().containsKey(basis)) {
            if (basis instanceof StepLink) {
                ((StepLink) basis).generateJoFeature(feature);
            }
        }
        if (!feature.getFeatureMap().containsKey(reference)) {
            ((StepLink) reference).generateJoFeature(feature);
        }
        JoFeature basisFeature = feature.getFeatureMap().get(basis);
        JoFeature referenceFeature = feature.getFeatureMap().get(reference);
        JoPCurve joPCurve = new JoPCurve(basisFeature, referenceFeature);
        joPCurve.setIntID(super.getId());
        joPCurve.setName(super.getName());
        feature.getFeatureMap().put(this, joPCurve);

    }

    @Override
    public void regenerate() throws Exception {

    }
}
