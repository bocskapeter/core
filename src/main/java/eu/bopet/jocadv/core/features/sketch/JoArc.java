package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.features.FeatureBase;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.vector.JoValue;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.ArrayList;
import java.util.List;

public class JoArc extends FeatureBase implements SketchGeometry, Selectable {
    private final JoCircle circle;
    private final JoPoint point1;
    private final JoPoint point2;

    public JoArc(JoCircle circle, JoPoint point1, JoPoint point2) {
        this.circle = circle;
        this.point1 = point1;
        this.point2 = point2;
    }

    public JoArc(JoPoint center, JoValue radius, JoPlane plane, JoPoint point1, JoPoint point2) {
        JoSphere sphere = new JoSphere(center, radius);
        this.circle = new JoCircle(sphere, plane);
        this.point1 = point1;
        this.point2 = point2;
    }

    public JoValue getRadius() {
        return circle.getSphere().getRadius();
    }

    public JoCircle getCircle() {
        return circle;
    }

    public JoPoint get1stPoint() {
        return point1;
    }

    public JoPoint get2ndPoint() {
        return point2;
    }

    @Override
    public double distance(Line pickingLine) {
        return circle.distance(pickingLine);
    }

    @Override
    public List<JoValue> getValues() {
        List<JoValue> result = new ArrayList<>(circle.getValues());
        result.addAll(point1.getValues());
        result.addAll(point2.getValues());
        return result;
    }

    @Override
    public List<JoPoint> getPoints() {
        List<JoPoint> result = new ArrayList<>(circle.getPoints());
        result.add(point1);
        result.add(point2);
        return result;
    }

    @Override
    public String toString() {
        String name = "⤺";
        if (this.getName() != null) name = this.getName();
        return name + "{" + circle + " ↤ " + point1 + " ↦ " + point2 + '}';
    }
}
