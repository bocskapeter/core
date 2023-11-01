package eu.bopet.jocadv.core.features.basic;

import eu.bopet.jocadv.core.features.JoBaseFeature;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.Selectable;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.List;

public class JoStraightEdge extends JoBaseFeature implements JoFeature, Selectable, JoEdge {
    private List<JoPoint> points;
    private boolean orientation;
    private RegenerativeLink regenerativeLink;

    public JoStraightEdge(List<JoPoint> points, boolean orientation, RegenerativeLink regenerativeLink) {
        this.points = points;
        this.orientation = orientation;
        this.regenerativeLink = regenerativeLink;
    }

    public List<JoPoint> getPoints() {
        return points;
    }

    public boolean isOrientation() {
        return orientation;
    }

    @Override
    public RegenerativeLink getRegenerativeLink() {
        return regenerativeLink;
    }

    @Override
    public void setRegenerativeLink(RegenerativeLink newRegenerativeLink) {
        this.regenerativeLink = newRegenerativeLink;
    }

    @Override
    public void replaceReferenceLink(RegenerativeLink newRegenerativeLink) throws Exception {
        JoFeature.super.replaceReferenceLink(newRegenerativeLink);
    }

    @Override
    public double distance(Line pickingLine) {
        return 0;
    }

    @Override
    public String toString() {
        return "JoEdge{" +
                "points=" + points +
                '}';
    }

    @Override
    public boolean isOn(JoPoint point) {
        // TODO point on edge
        return false;
    }

    @Override
    public void reverse() {
        this.orientation = !this.orientation;
    }

    @Override
    public boolean sameSense() {
        return this.orientation;
    }

    @Override
    public JoEdge getReverse() {
        return new JoStraightEdge(points, !orientation, regenerativeLink);
    }
}
