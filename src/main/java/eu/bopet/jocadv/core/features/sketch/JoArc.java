package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.features.FeatureBase;
import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import org.apache.commons.math3.geometry.euclidean.threed.Line;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class JoArc extends FeatureBase implements SketchGeometry, Selectable {
    private final JoCircle circle;
    private final JoPoint point1;
    private final JoPoint point2;
    private final JoLine line1;
    private final JoLine line2;

    public JoArc(JoCircle circle, JoPoint point1, JoPoint point2) {
        this.circle = circle;
        this.point1 = point1;
        this.point2 = point2;
        this.line1 = new JoLine(circle.getCenter(), point1, true);
        this.line2 = new JoLine(circle.getCenter(), point2, true);
    }

    public JoArc(JoPoint center, JoValue radius, JoPlane plane, JoPoint point1, JoPoint point2) throws Exception {
        JoSphere sphere = new JoSphere(center, radius);
        this.circle = new JoCircle(sphere, plane);
        this.point1 = point1;
        this.point2 = point2;
        this.line1 = new JoLine(circle.getCenter(), point1, true);
        this.line2 = new JoLine(circle.getCenter(), point2, true);
    }

    public JoValue getRadius() {
        return circle.getSphere().getRadius();
    }

    public double getRadiusD() {
        return circle.getRadiusD();
    }

    public JoCircle getCircle() {
        return circle;
    }

    public JoPoint getCenter() {
        return circle.getCenter();
    }

    public Vector3D getCenter3D() {
        return circle.getCenter3D();
    }

    public JoPoint get1stPoint() {
        return point1;
    }

    public JoPoint get2ndPoint() {
        return point2;
    }

    public JoLine getLine1() {
        return line1;
    }

    public JoLine getLine2() {
        return line2;
    }

    public boolean isOn(JoPoint point) {
        if (!circle.isOn(point)) return false;
        Vector3D r1 = point1.getVector3D().subtract(circle.getCenter3D());
        Vector3D r2 = point2.getVector3D().subtract(circle.getCenter3D());
        Vector3D rp = point.getVector3D().subtract(circle.getCenter3D());
        double firstAngle = Vector3D.angle(r1, rp);
        double secondAngle = Vector3D.angle(r1, r2);
        return firstAngle < secondAngle;
    }

    @Override
    public double distance(Line pickingLine) {
        return circle.distance(pickingLine);
    }

    @Override
    public Set<JoValue> getValues() {
        Set<JoValue> result = new LinkedHashSet<>(circle.getValues());
        result.addAll(point1.getValues());
        result.addAll(point2.getValues());
        return result;
    }

    @Override
    public Set<JoPoint> getPoints() {
        Set<JoPoint> result = new LinkedHashSet<>(circle.getPoints());
        result.add(point1);
        result.add(point2);
        return result;
    }

    @Override
    public List<JoPoint> getIntersection(SketchGeometry geometry) {

        // TODO calculate intersection with arc, circle and line
        return null;
    }

    @Override
    public String toString() {
        String name = "⤺";
        if (this.getName() != null) name = this.getName();
        return name + "{" + circle + " ↤ " + point1 + " ↦ " + point2 + '}';
    }
}
