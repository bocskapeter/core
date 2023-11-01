package eu.bopet.jocadv.core.features.basic;

import eu.bopet.jocadv.core.features.JoBaseFeature;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.basic.curve.JoCurve;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.ArrayList;
import java.util.List;

public class JoCircle extends JoBaseFeature implements Selectable, JoFeature, JoCurve, JoEdge {
    private final JoPoint center;
    private final JoPoint firstPoint;
    private final JoPlane plane;
    private boolean direction;

    public JoCircle(JoPoint center, JoPoint firstPoint, JoPlane plane) {
        this.center = center;
        this.firstPoint = firstPoint;
        this.plane = plane;
        direction = true;
    }

    public JoCircle(JoPoint center, JoPoint firstPoint, JoPlane plane, boolean direction) {
        this.center = center;
        this.firstPoint = firstPoint;
        this.plane = plane;
        this.direction = direction;
    }

    @Override
    public boolean isOn(JoPoint point) {
        return false;
    }

    @Override
    public RegenerativeLink getRegenerativeLink() {
        return null;
    }

    @Override
    public void setRegenerativeLink(RegenerativeLink newRegenerativeLink) {

    }

    @Override
    public double distance(Line pickingLine) {
        return 0;
    }

    @Override
    public List<JoPoint> getPoints() {
        List<JoPoint> points = new ArrayList<>();
        points.add(firstPoint);
        return points;
    }

    @Override
    public void reverse() {
        this.direction = !this.direction;
    }

    @Override
    public boolean sameSense() {
        return this.direction;
    }

    @Override
    public JoEdge getReverse() {
        return new JoCircle(center, firstPoint, plane, !direction);
    }

    @Override
    public String toString() {
        String name = "⨀";
        if (this.getName() != null) name = this.getName();
        return name + "{" + center + " ⤓ " + firstPoint + " T/F: " + direction + '}';
    }
}
