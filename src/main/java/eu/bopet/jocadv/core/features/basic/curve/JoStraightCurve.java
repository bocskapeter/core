package eu.bopet.jocadv.core.features.basic.curve;

import eu.bopet.jocadv.core.features.JoBaseFeature;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.basic.JoEdge;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.List;

public class JoStraightCurve extends JoBaseFeature implements JoFeature, Selectable, JoCurve {
    private List<JoPoint> points;
    private RegenerativeLink regenerativeLink;

    public JoStraightCurve(List<JoPoint> points, RegenerativeLink regenerativeLink) {
        this.points = points;
        this.regenerativeLink = regenerativeLink;
    }

    public List<JoPoint> getPoints() {
        return points;
    }


    @Override
    public boolean isOn(JoPoint point) {
        return false;
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
    public double distance(Line pickingLine) {
        return 0;
    }
}
