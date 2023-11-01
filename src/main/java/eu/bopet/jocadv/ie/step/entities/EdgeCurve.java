package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.core.features.JoBaseFeature;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.basic.JoCircle;
import eu.bopet.jocadv.core.features.basic.JoEdge;
import eu.bopet.jocadv.core.features.basic.JoStraightEdge;
import eu.bopet.jocadv.core.features.basic.curve.JoStraightCurve;
import eu.bopet.jocadv.ie.step.StepEntity;
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
        StepEntity stepEntity = feature.getStepEntityByID(super.getId3());
        JoEdge joEdge = null;
        if (stepEntity instanceof Line) {
            Line line = (Line) stepEntity;
            if (!feature.getFeatureMap().containsKey(line)) {
                line.generateJoFeature(feature);
            }
            JoStraightCurve joStraightCurve = (JoStraightCurve) feature.getFeatureMap().get(line);
            joEdge = new JoStraightEdge(joStraightCurve.getPoints(), super.isaBoolean(), null);
        }
        if (stepEntity instanceof Circle) {
            Circle circle = (Circle) stepEntity;
            if (!feature.getFeatureMap().containsKey(circle)) {
                circle.generateJoFeature(feature);
            }
            joEdge = (JoCircle) feature.getFeatureMap().get(circle);
        }
        if (stepEntity instanceof BSplineCurveWithKnots) {
            BSplineCurveWithKnots spline = (BSplineCurveWithKnots) stepEntity;
            if (!feature.getFeatureMap().containsKey(spline)) {
                spline.generateJoFeature(feature);
            }
            joEdge = (JoEdge) feature.getFeatureMap().get(spline);
        }
        if (stepEntity instanceof Ellipse) {
            Ellipse ellipse = (Ellipse) stepEntity;
            if (!feature.getFeatureMap().containsKey(ellipse)) {
                ellipse.generateJoFeature(feature);
            }
            joEdge = (JoEdge) feature.getFeatureMap().get(ellipse);
        }
        if (stepEntity instanceof SeamCurve) {
            SeamCurve seamCurve = (SeamCurve) stepEntity;
            if (!feature.getFeatureMap().containsKey(seamCurve)) {
                seamCurve.generateJoFeature(feature);
            }
            joEdge = (JoEdge) feature.getFeatureMap().get(seamCurve);
        }
        if (joEdge != null && joEdge instanceof JoBaseFeature) {
            JoBaseFeature joBaseFeature = (JoBaseFeature) joEdge;
            joBaseFeature.setIntID(super.getId());
            joBaseFeature.setName(super.getName());
            feature.getFeatureMap().put(this, (JoFeature) joEdge);
        } else {
            System.out.println("EdgeCurve processing - Unknown curve: " + stepEntity);
        }

    }

    @Override
    public void regenerate() throws Exception {

    }
}
