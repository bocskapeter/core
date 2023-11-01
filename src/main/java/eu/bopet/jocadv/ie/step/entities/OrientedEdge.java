package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.core.features.JoBaseFeature;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.basic.JoEdge;
import eu.bopet.jocadv.ie.step.StepEntity;
import eu.bopet.jocadv.ie.step.StepFeature;
import eu.bopet.jocadv.ie.step.StepLink;
import eu.bopet.jocadv.ie.step.util.UtilIntIntIntBoolean;

public class OrientedEdge extends UtilIntIntIntBoolean implements StepLink {
    public OrientedEdge(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "OrientedEdge{" + super.toString() + '}';
    }

    @Override
    public void generateJoFeature(StepFeature feature) throws Exception {
        StepEntity stepEntity = feature.getStepEntityByID(super.getId3());
        if (stepEntity instanceof EdgeCurve) {
            EdgeCurve edgeCurve = (EdgeCurve) stepEntity;
            if (!feature.getFeatureMap().containsKey(edgeCurve)) {
                edgeCurve.generateJoFeature(feature);
            }
            JoEdge joEdge = (JoEdge) feature.getFeatureMap().get(edgeCurve);
            if (joEdge != null && joEdge instanceof JoBaseFeature) {
                JoBaseFeature joFeature = (JoBaseFeature) joEdge;
                joFeature.setIntID(super.getId());
                joFeature.setName(super.getName());
                feature.getFeatureMap().put(this, (JoFeature) joFeature);
            }
        } else {
            System.out.println("Unknown edge: " + stepEntity);
        }
    }

    @Override
    public void regenerate() throws Exception {

    }
}
