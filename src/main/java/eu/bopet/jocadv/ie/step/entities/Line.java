package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.core.features.sketch.JoSValue;
import eu.bopet.jocadv.core.features.basic.curve.JoStraightCurve;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.vector.JoVector;
import eu.bopet.jocadv.ie.step.StepFeature;
import eu.bopet.jocadv.ie.step.StepLink;
import eu.bopet.jocadv.ie.step.util.UtilIntInt;

import java.util.ArrayList;
import java.util.List;

public class Line extends UtilIntInt implements StepLink {

    public Line(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "Line{" + super.toString() + '}';
    }

    @Override
    public void generateJoFeature(StepFeature feature) {
        CartesianPoint cartesianPoint = (CartesianPoint) feature.getStepEntityByID(this.get1st());
        Vector vector = (Vector) feature.getStepEntityByID(this.get2nd());
        if (!feature.getFeatureMap().containsKey(cartesianPoint)) {
            cartesianPoint.generateJoFeature(feature);
        }
        if (!feature.getFeatureMap().containsKey(vector)) {
            vector.generateJoFeature(feature);
        }
        JoPoint firstPoint = (JoPoint) feature.getFeatureMap().get(cartesianPoint);
        JoVector lineVector = (JoVector) feature.getFeatureMap().get(vector);
        JoPoint secondPoint = new JoPoint(JoSValue.AUTO, firstPoint.getVector3D().add(lineVector.getVector3D()));
        List<JoPoint> points = new ArrayList<>();
        points.add(firstPoint);
        points.add(secondPoint);
        JoStraightCurve joStraightCurve = new JoStraightCurve(points, null);
        joStraightCurve.setIntID(super.getId());
        joStraightCurve.setName(super.getName());
        feature.getFeatureMap().put(this, joStraightCurve);
    }

    @Override
    public void regenerate() throws Exception {
        // TODO
    }
}
