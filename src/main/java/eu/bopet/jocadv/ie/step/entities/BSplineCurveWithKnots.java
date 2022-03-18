package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.curve.BSplineCurveForm;
import eu.bopet.jocadv.ie.step.curve.KnotType;
import eu.bopet.jocadv.ie.step.util.StepEntityBase;

import java.util.ArrayList;
import java.util.List;

public class BSplineCurveWithKnots extends StepEntityBase {
    private int degree;
    private List<Integer> pointIdList;
    private BSplineCurveForm curveForm;
    private boolean closedCurve;
    private boolean selfIntersect;
    private List<Integer> knotMultiplicities;
    private List<Double> knots;
    private KnotType knotType;

    public BSplineCurveWithKnots(int id, String name, String attribute) {
        super(id, name);
        String[] values = attribute.split(",");
        degree = Integer.parseInt(values[0]);
        String substring = attribute.substring(attribute.indexOf("(") + 1, attribute.indexOf(")"))
                .replaceAll(" ", "");
        String[] pointIDs = substring.split(",");
        pointIdList = new ArrayList<>();
        for (String pointId : pointIDs) {
            int pId = Integer.parseInt(pointId.substring(1));
            pointIdList.add(pId);
        }
        substring = attribute.substring(attribute.indexOf(")") + 1);
        String[] parts = substring.split(",");
        curveForm =
                BSplineCurveForm.valueOf(parts[1].replace(".", "").stripLeading().stripTrailing());
        closedCurve = parts[2].contains("T");
        selfIntersect = parts[3].contains("T");
        String knotStrings = substring.substring(substring.indexOf("(") + 1, substring.indexOf(")"));
        String[] knotStringArray = knotStrings.split(",");
        knotMultiplicities = new ArrayList<>();
        for (String knotString : knotStringArray) {
            int knotInt = Integer.parseInt(knotString.stripLeading());
            knotMultiplicities.add(knotInt);
        }
        substring = substring.substring(substring.indexOf(")") + 1);
        knotStrings = substring.substring(substring.indexOf("(") + 1, substring.indexOf(")"));
        knotStringArray = knotStrings.split(",");
        knots = new ArrayList<>();
        for (String knotString : knotStringArray) {
            double knot = Double.parseDouble(knotString);
            knots.add(knot);
        }
        substring = substring.substring(substring.indexOf(")") + 1);
        parts = substring.split(",");
        knotType = KnotType.valueOf(parts[1].replace(".", "").stripLeading().stripTrailing());
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
