package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.features.FeatureBase;
import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import org.apache.commons.math3.geometry.euclidean.threed.Line;
import org.apache.commons.math3.geometry.euclidean.threed.SubLine;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class JoLine extends FeatureBase implements SketchGeometry, Selectable {
    private final JoPoint point1;
    private final JoPoint point2;
    private final boolean construction;

    public JoLine(JoPoint point1, JoPoint point2) {
        this.point1 = point1;
        this.point2 = point2;
        this.construction = false;
    }

    public JoLine(JoPoint point1, JoPoint point2, boolean construction) {
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

    @Override
    public double distance(Line pickingLine) {
        return pickingLine.distance(getLine());
    }

    @Override
    public Set<JoValue> getValues() {
        Set<JoValue> result = new LinkedHashSet<>();
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
        if (geometry instanceof JoLine) {
            JoLine otherLine = (JoLine) geometry;
            Vector3D sectionPoint = this.getSubLine().intersection(otherLine.getSubLine(), false);
            if (sectionPoint != null) {
                result.add(new JoPoint(sectionPoint));
                return result;
            }
        }
        if (geometry instanceof JoCircle) {
            JoCircle circle = (JoCircle) geometry;
            Vector3D centerPoint = circle.getCenter3D();
            double difference = getLine().distance(centerPoint) - circle.getRadiusD();
            if (difference <= -getTolerance()) {
                // TODO intersecting circle with two intersecting points

            }

            if (-getTolerance() < difference && difference < getTolerance()) {
                // TODO tangent circle and one tangent point

            }

        }
        // TODO calculate intersection with arc
        return null;
    }

    @Override
    public String toString() {
        String name = "/";
        if (this.getName() != null) name = this.getName();
        return name + "{" + "↦ " + point1 + " ↤ " + point2 + '}';
    }
}
