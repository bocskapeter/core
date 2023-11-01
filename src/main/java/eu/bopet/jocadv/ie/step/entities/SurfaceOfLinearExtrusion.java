package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.core.features.basic.curve.JoCurve;
import eu.bopet.jocadv.core.features.surface.JoLinearExtrusionSurface;
import eu.bopet.jocadv.core.features.vector.JoVector;
import eu.bopet.jocadv.ie.step.StepEntity;
import eu.bopet.jocadv.ie.step.StepFeature;
import eu.bopet.jocadv.ie.step.StepLink;
import eu.bopet.jocadv.ie.step.util.UtilIntInt;

public class SurfaceOfLinearExtrusion extends UtilIntInt implements StepLink {

    public SurfaceOfLinearExtrusion(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "SurfaceOfLinearExtrusion{" + super.toString() + '}';
    }

    @Override
    public void generateJoFeature(StepFeature feature) throws Exception {
        StepEntity curve = feature.getStepEntityByID(super.get1st());
        StepEntity vector = feature.getStepEntityByID(super.get2nd());
        if (!feature.getFeatureMap().containsKey(curve)) {
            ((StepLink) curve).generateJoFeature(feature);
        }
        if (!feature.getFeatureMap().containsKey(vector)) {
            ((StepLink) vector).generateJoFeature(feature);
        }
        JoCurve curveFeature = (JoCurve) feature.getFeatureMap().get(curve);
        JoVector vectorFeature = (JoVector) feature.getFeatureMap().get(vector);
        JoLinearExtrusionSurface surface = new JoLinearExtrusionSurface(curveFeature, vectorFeature);
        surface.setIntID(super.getId());
        surface.setName(super.getName());
        feature.getFeatureMap().put(this, surface);
    }

    @Override
    public void regenerate() throws Exception {

    }
}
