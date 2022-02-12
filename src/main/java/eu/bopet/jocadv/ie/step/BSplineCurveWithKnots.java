package eu.bopet.jocadv.ie.step;

import java.util.List;

public class BSplineCurveWithKnots extends StepEntity {
    private int degree;
    private List<Integer> pointIdList;
    private BSplineCurveForm curveForm;
    private boolean closedCurve;
    private boolean selfIntersect;
    private List<Integer> knotMultiplicities;
    private List<Double> knots;
    private KnotType knotType;

    public BSplineCurveWithKnots(int degree, List<Integer> pointIdList, BSplineCurveForm curveForm,
                                 boolean closedCurve, boolean selfIntersect, List<Integer> knotMultiplicities,
                                 List<Double> knots, KnotType knotType) {
        this.degree = degree;
        this.pointIdList = pointIdList;
        this.curveForm = curveForm;
        this.closedCurve = closedCurve;
        this.selfIntersect = selfIntersect;
        this.knotMultiplicities = knotMultiplicities;
        this.knots = knots;
        this.knotType = knotType;
    }

    @Override
    public String toString() {
        return "BSplineCurveWithKnots{" + super.toString() +
                " degree=" + degree +
                ", pointIdList=" + pointIdList +
                ", curveForm=" + curveForm +
                ", closedCurve=" + closedCurve +
                ", selfIntersect=" + selfIntersect +
                ", knotMultiplicities=" + knotMultiplicities +
                ", knots=" + knots +
                ", knotType=" + knotType +
                '}';
    }
}
