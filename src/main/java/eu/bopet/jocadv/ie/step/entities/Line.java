package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.basic.JoEdge;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.vector.JoVector;
import eu.bopet.jocadv.ie.step.StepFeature;
import eu.bopet.jocadv.ie.step.StepLink;
import eu.bopet.jocadv.ie.step.util.UtilIntInt;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Line extends UtilIntInt implements StepLink {
    private CartesianPoint point;
    private Vector vector;
    private Direction direction;
    private Vector3D direction3D;
    private Set<JoPoint> points;


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
        JoPoint secondPoint = new JoPoint(JoValue.IMPORTED, firstPoint.getVector3D().add(lineVector.getVector3D()));
        List<JoPoint> points = new ArrayList<>();
        points.add(firstPoint);
        points.add(secondPoint);
        JoEdge joEdge = new JoEdge(points, null);
        joEdge.setIntID(super.getId());
        joEdge.setName(super.getName());
        feature.getFeatureMap().put(this, joEdge);
    }

    @Override
    public void regenerate() throws Exception {
        // TODO
    }
}
