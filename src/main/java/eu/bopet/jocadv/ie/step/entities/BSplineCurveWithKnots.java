package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.basic.curve.JoBSplineCurveForm;
import eu.bopet.jocadv.core.features.basic.curve.JoBSplineCurveKnotType;
import eu.bopet.jocadv.core.features.basic.curve.JoBSplineCurveWithKnots;
import eu.bopet.jocadv.ie.step.StepEntity;
import eu.bopet.jocadv.ie.step.StepFeature;
import eu.bopet.jocadv.ie.step.StepLink;

import java.util.ArrayList;
import java.util.List;

public class BSplineCurveWithKnots extends StepEntity implements StepLink {
    private int degree;
    private List<Integer> pointIdList;
    private JoBSplineCurveForm curveForm;
    private boolean closedCurve;
    private boolean selfIntersect;
    private List<Integer> knotMultiplicities;
    private List<Double> knots;
    private JoBSplineCurveKnotType knotType;

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
                JoBSplineCurveForm.valueOf(parts[1].replace(".", "").stripLeading().stripTrailing());
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
        knotType = JoBSplineCurveKnotType.valueOf(parts[1].replace(".", "")
                .stripLeading().stripTrailing());
    }

    @Override
    public void generateJoFeature(StepFeature feature) throws Exception {
        List<JoPoint> joPointList = new ArrayList<>();
        for (int i : pointIdList) {
            StepEntity stepEntity = feature.getStepEntityByID(i);
            if (stepEntity instanceof StepLink) {
                if (!feature.getFeatureMap().containsKey(stepEntity)) {
                    ((StepLink) stepEntity).generateJoFeature(feature);
                }
                JoFeature joFeature = feature.getFeatureMap().get(stepEntity);
                if (joFeature instanceof JoPoint) {
                    joPointList.add((JoPoint) joFeature);
                } else {
                    System.out.println("Unknown feature here: " + joFeature);
                    System.out.println("--- : " + this);
                }
            } else {
                System.out.println("Unknown Step Entity: " + stepEntity);
                System.out.println("--- : " + this);
            }
        }
        JoBSplineCurveWithKnots spline = new JoBSplineCurveWithKnots(degree, joPointList, curveForm, closedCurve,
                selfIntersect, knotMultiplicities, knots, knotType);
        spline.setIntID(super.getId());
        spline.setName(super.getName());
        feature.getFeatureMap().put(this, spline);
    }

    @Override
    public void regenerate() throws Exception {

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
