package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.features.JoBaseFeature;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import org.apache.commons.math3.geometry.euclidean.threed.Line;
import org.apache.commons.math3.geometry.euclidean.threed.SubLine;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class JoSLine extends JoBaseFeature implements SketchGeometry, Selectable {
    private final JoPoint point1;
    private final JoPoint point2;
    private final boolean construction;

    public JoSLine(JoPoint point1, JoPoint point2) {
        this.point1 = point1;
        this.point2 = point2;
        this.construction = false;
    }

    public JoSLine(JoPoint point1, JoPoint point2, boolean construction) {
        this.point1 = point1;
        this.point2 = point2;
        this.construction = construction;
    }

    public JoPoint get1stPoint() {
        return point1;
    }

    public JoPoint get2ndPoint() {
        return point2;
    }

    public boolean isConstruction() {
        return construction;
    }

    public SubLine getSubLine() {
        return new SubLine(point1.getVector().getVector3D(), point2.getVector().getVector3D(), this.getTolerance());
    }

    public Line getLine() {
        return new Line(point1.getVector().getVector3D(), point2.getVector().getVector3D(), this.getTolerance());
    }

    private List<JoPoint> getLineCircleIntersection(JoSCircle circle) {
        List<JoPoint> result = new ArrayList<>();
        double difference = getLine().distance(circle.getCenter3D()) - circle.getRadiusD();
        if (difference <= 0.0) {
            double cx = circle.getCenter3D().getX();
            double cy = circle.getCenter3D().getY();
            double cz = circle.getCenter3D().getZ();
            double px = point1.getVector3D().getX();
            double py = point1.getVector3D().getY();
            double pz = point1.getVector3D().getZ();
            double vx = point2.getVector3D().getX() - px;
            double vy = point2.getVector3D().getY() - py;
            double vz = point2.getVector3D().getZ() - pz;
            double A = vx * vx + vy * vy + vz * vz;
            double B = 2.0 * (px * vx + py * vy + pz * vz - vx * cx - vy * cy - vz * cz);
            double C = px * px - 2 * px * cx + cx * cx + py * py - 2 * py * cy + cy * cy +
                    pz * pz - 2 * pz * cz + cz * cz - circle.getRadiusD() * circle.getRadiusD();
            double D = B * B - 4 * A * C;
            double t1 = (-B - Math.sqrt(D)) / (2.0 * A);
            Vector3D sectionPoint1 = new Vector3D(
                    point1.getVector3D().getX() * (1 - t1) + t1 * point2.getVector3D().getX(),
                    point1.getVector3D().getY() * (1 - t1) + t1 * point2.getVector3D().getY(),
                    point1.getVector3D().getZ() * (1 - t1) + t1 * point2.getVector3D().getZ());
            double t2 = (-B + Math.sqrt(D)) / (2.0 * A);
            Vector3D sectionPoint2 = new Vector3D(
                    point1.getVector3D().getX() * (1 - t2) + t2 * point2.getVector3D().getX(),
                    point1.getVector3D().getY() * (1 - t2) + t2 * point2.getVector3D().getY(),
                    point1.getVector3D().getZ() * (1 - t2) + t2 * point2.getVector3D().getZ());
            double distance = sectionPoint1.distance(sectionPoint2);
            if (t1 > 0.0 && t1 < 1.0) {
                if (t2 > 0.0 && t2 < 1.0) {
                    if (distance >= getTolerance()) {
                        result.add(new JoPoint(JoSValue.VARIABLE, sectionPoint1));
                        result.add(new JoPoint(JoSValue.VARIABLE, sectionPoint2));
                    } else {
                        Vector3D sP1ToSP2 = sectionPoint2.subtract(sectionPoint1);
                        Vector3D half = sP1ToSP2.scalarMultiply(0.5);
                        Vector3D sectionPoint = sectionPoint1.add(half);
                        result.add(new JoPoint(JoSValue.VARIABLE, sectionPoint));
                    }
                } else {
                    result.add(new JoPoint(JoSValue.VARIABLE, sectionPoint1));
                }
            } else if (t2 > 0.0 && t2 < 1.0) {
                result.add(new JoPoint(JoSValue.VARIABLE, sectionPoint2));
            }
        }
        return result;
    }

    @Override
    public boolean isOn(JoPoint point) {
        return getLine().contains(point.getVector3D());
    }

    @Override
    public double distance(Line pickingLine) {
        return pickingLine.distance(getLine());
    }

    @Override
    public Set<JoSValue> getValues() {
        Set<JoSValue> result = new LinkedHashSet<>();
        result.addAll(point1.getValues());
        result.addAll(point2.getValues());
        return result;
    }

    @Override
    public Set<JoPoint> getPoints() {
        Set<JoPoint> result = new LinkedHashSet<>();
        result.add(point1);
        result.add(point2);
        return result;
    }

    @Override
    public List<JoPoint> getIntersection(SketchGeometry geometry) {
        List<JoPoint> result = new ArrayList<>();
        if (geometry instanceof JoSLine) {
            JoSLine otherLine = (JoSLine) geometry;
            Vector3D sectionPoint = this.getSubLine().intersection(otherLine.getSubLine(), false);
            if (sectionPoint != null) {
                result.add(new JoPoint(JoSValue.VARIABLE, sectionPoint));
                return result;
            }
        }
        if (geometry instanceof JoSCircle) {
            JoSCircle circle = (JoSCircle) geometry;
            return getLineCircleIntersection(circle);
        }
        if (geometry instanceof JoSArc) {
            JoSArc arc = (JoSArc) geometry;
            result = getLineCircleIntersection(arc.getCircle());
            if (!result.isEmpty()) {
                if (result.size() == 1) {
                    JoPoint tangentPoint = result.get(0);
                    if (!arc.isOn(tangentPoint)) {
                        result.clear();
                    }
                    return result;
                }
                if (result.size() == 2) {
                    JoPoint p1 = result.get(0);
                    JoPoint p2 = result.get(1);
                    result.clear();
                    if (arc.isOn(p1)) {
                        result.add(p1);
                    }
                    if (arc.isOn(p2)) {
                        result.add(p2);
                    }
                    return result;
                }
            } else {
                result.clear();
                return result;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String name = "/";
        if (this.getName() != null) name = this.getName();
        return name + "{" + "↦ " + point1 + " ↤ " + point2 + '}';
    }
}
