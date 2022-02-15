package eu.bopet.jocadv.ie.step;

import java.util.ArrayList;
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

    public static BSplineCurveWithKnots getInstance(int id, String name, String attribute) {
        String[] values = attribute.split(",");
        int degree = Integer.parseInt(values[0]);
        String substring = attribute.substring(attribute.indexOf("(") + 1, attribute.indexOf(")"))
                .replaceAll(" ", "");
        String[] pointIDs = substring.split(",");
        List<Integer> pointIdList = new ArrayList<>();
        for (String pointId : pointIDs) {
            int pId = Integer.parseInt(pointId.substring(1));
            pointIdList.add(pId);
        }
        substring = attribute.substring(attribute.indexOf(")") + 1);
        String[] parts = substring.split(",");
        BSplineCurveForm curveForm =
                BSplineCurveForm.valueOf(parts[1].replace(".", ""));
        boolean closedCurve = parts[2].contains("T");
        boolean selfIntersect = parts[3].contains("T");
        String knotStrings = substring.substring(substring.indexOf("(") + 1, substring.indexOf(")"));
        String[] knotStringArray = knotStrings.split(",");
        List<Integer> knotMultiplicities = new ArrayList<>();
        for (String knotString : knotStringArray) {
            int knotInt = Integer.parseInt(knotString);
            knotMultiplicities.add(knotInt);
        }
        substring = substring.substring(substring.indexOf(")") + 1);
        knotStrings = substring.substring(substring.indexOf("(") + 1, substring.indexOf(")"));
        knotStringArray = knotStrings.split(",");
        List<Double> knots = new ArrayList<>();
        for (String knotString : knotStringArray) {
            double knot = Double.parseDouble(knotString);
            knots.add(knot);
        }
        substring = substring.substring(substring.indexOf(")") + 1);
        parts = substring.split(",");
        KnotType knotType = KnotType.valueOf(parts[1].replace(".", ""));
        BSplineCurveWithKnots bSplineCurveWithKnots
                = new BSplineCurveWithKnots(degree, pointIdList, curveForm, closedCurve, selfIntersect,
                knotMultiplicities, knots, knotType);
        bSplineCurveWithKnots.setId(id);
        bSplineCurveWithKnots.setName(name);
        return bSplineCurveWithKnots;
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
