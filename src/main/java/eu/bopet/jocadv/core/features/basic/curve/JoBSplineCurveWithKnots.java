package eu.bopet.jocadv.core.features.basic.curve;

import eu.bopet.jocadv.core.features.JoBaseFeature;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.basic.JoEdge;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.List;

public class JoBSplineCurveWithKnots extends JoBaseFeature implements JoFeature, Selectable, JoCurve, JoEdge {
    private int degree;
    private List<JoPoint> points;
    private JoBSplineCurveForm curveForm;
    private boolean closedCurve;
    private boolean selfIntersect;
    private List<Integer> knotMultiplicities;
    private List<Double> knots;
    private JoBSplineCurveKnotType knotType;

    public JoBSplineCurveWithKnots(int degree, List<JoPoint> points, JoBSplineCurveForm curveForm, boolean closedCurve,
                                   boolean selfIntersect, List<Integer> knotMultiplicities, List<Double> knots,
                                   JoBSplineCurveKnotType knotType) {
        this.degree = degree;
        this.points = points;
        this.curveForm = curveForm;
        this.closedCurve = closedCurve;
        this.selfIntersect = selfIntersect;
        this.knotMultiplicities = knotMultiplicities;
        this.knots = knots;
        this.knotType = knotType;
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
