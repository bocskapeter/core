package eu.bopet.jocadv.core.features.basic;

import eu.bopet.jocadv.core.features.JoBaseFeature;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.basic.curve.JoCurve;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.List;

public class JoEllipse extends JoBaseFeature implements Selectable, JoFeature, JoCurve, JoEdge{
    private JoPoint center;
    private JoPoint firstAxis;
    private JoPoint secondAxis;

    public JoEllipse(JoPoint center, JoPoint firstAxis, JoPoint secondAxis) {
        this.center = center;
        this.firstAxis = firstAxis;
        this.secondAxis = secondAxis;
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
        return null;
    }

    @Override
    public void reverse() {

    }

    @Override
    public boolean sameSense() {
        return false;
    }

    @Override
    public JoEdge getReverse() {
        return null;
    }
}
