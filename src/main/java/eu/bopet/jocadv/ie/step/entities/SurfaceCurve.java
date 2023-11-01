package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntity;
import eu.bopet.jocadv.ie.step.StepFeature;
import eu.bopet.jocadv.ie.step.StepLink;
import eu.bopet.jocadv.ie.step.util.UtilIntListOfIntPreferredSurfaceCurveRepresentation;

public class SurfaceCurve extends UtilIntListOfIntPreferredSurfaceCurveRepresentation implements StepLink {

    public SurfaceCurve(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "SurfaceCurve{" + super.toString() + '}';
    }

    @Override
    public void generateJoFeature(StepFeature feature) throws Exception {
        StepEntity stepEntity = feature.getStepEntityByID(super.getCurveId());
        if (!feature.getFeatureMap().containsKey(stepEntity)) {
            if (stepEntity instanceof StepLink) {
                ((StepLink) stepEntity).generateJoFeature(feature);
            } else {
                System.out.println("Not processed STEP entity: " + stepEntity);
            }
        }

    }

    @Override
    public void regenerate() throws Exception {

    }
}
