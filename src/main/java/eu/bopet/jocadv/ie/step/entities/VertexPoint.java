package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.ie.step.StepFeature;
import eu.bopet.jocadv.ie.step.StepLink;
import eu.bopet.jocadv.ie.step.util.UtilInt;

public class VertexPoint extends UtilInt implements StepLink {

    public VertexPoint(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "VertexPoint{" + super.toString() + '}';
    }

    @Override
    public void generateJoFeature(StepFeature feature) throws Exception {
        CartesianPoint cartesianPoint = (CartesianPoint) feature.getStepEntityByID(super.getIntId());
        if (!feature.getFeatureMap().containsKey(cartesianPoint)) {
            cartesianPoint.generateJoFeature(feature);
        }
        JoPoint point = (JoPoint) feature.getFeatureMap().get(cartesianPoint);
        feature.getFeatureMap().put(this, point);
    }

    @Override
    public void regenerate() throws Exception {

    }
}
