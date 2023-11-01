package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.basic.curve.JoCurve;
import eu.bopet.jocadv.core.features.basic.curve.JoSeamCurve;
import eu.bopet.jocadv.ie.step.StepEntity;
import eu.bopet.jocadv.ie.step.StepFeature;
import eu.bopet.jocadv.ie.step.StepLink;
import eu.bopet.jocadv.ie.step.util.UtilIntListOfIntPreferredSurfaceCurveRepresentation;

import java.util.ArrayList;
import java.util.List;

public class SeamCurve extends UtilIntListOfIntPreferredSurfaceCurveRepresentation implements StepLink {

    public SeamCurve(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "SeamCurve{" + super.toString() + '}';
    }

    @Override
    public void generateJoFeature(StepFeature feature) throws Exception {
        StepEntity stepEntity = feature.getStepEntityByID(super.getCurveId());
        if (!feature.getFeatureMap().containsKey(stepEntity)) {
            if (stepEntity instanceof StepLink) {
                ((StepLink) stepEntity).generateJoFeature(feature);
            }
        }
        JoFeature joFeature = feature.getFeatureMap().get(stepEntity);
        List<JoFeature> featureList = new ArrayList<>();
        for (int i : super.getAssociatedGeometryIds()) {
            StepEntity entity = feature.getStepEntityByID(i);
            if (!feature.getFeatureMap().containsKey(entity)) {
                ((StepLink) entity).generateJoFeature(feature);
            }
            JoFeature associated = feature.getFeatureMap().get(entity);
            featureList.add(associated);
        }
        JoSeamCurve joSeamCurve = new JoSeamCurve((JoCurve) joFeature, featureList, super.getMasterRep());
        joSeamCurve.setIntID(super.getId());
        joSeamCurve.setName(super.getName());
        feature.getFeatureMap().put(this, joSeamCurve);
    }

    @Override
    public void regenerate() throws Exception {

    }
}
