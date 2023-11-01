package eu.bopet.jocadv.core.features.basic.curve;

import eu.bopet.jocadv.core.features.JoBaseFeature;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.basic.JoEdge;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.List;

public class JoSeamCurve extends JoBaseFeature implements JoFeature, Selectable, JoCurve, JoEdge {
    private JoCurve curve;
    private List<JoFeature> associated;
    private JoPreferredSurfaceCurveRepresentation representation;

    public JoSeamCurve(JoCurve curve, List<JoFeature> associated,
                       JoPreferredSurfaceCurveRepresentation representation) {
        this.curve = curve;
        this.associated = associated;
        this.representation = representation;
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
