package eu.bopet.jocadv.ie.step.surface;

import eu.bopet.jocadv.ie.step.util.KnotType;
import eu.bopet.jocadv.ie.step.util.StepEntityBase;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BSplineSurfaceWithKnots extends StepEntityBase {
    private int uDegree;
    private int vDegree;
    private List<List<Integer>> controlPoints;
    private BSplineSurfaceForm surfaceForm;
    private boolean uClosed;
    private boolean vClosed;
    private boolean selfIntersect;
    private List<Integer> uMultiplicities;
    private List<Integer> vMultiplicities;
    private List<Double> uKnots;
    private List<Double> vKnots;
    private KnotType knotType;

    public BSplineSurfaceWithKnots(int id, String name, String attribute) {
        super(id, name);
        String[] uvParts = attribute.replace(" ", "").split(",");
        uDegree = Integer.parseInt(uvParts[0]);
        vDegree = Integer.parseInt(uvParts[1]);
        controlPoints = new ArrayList<>();
        String cPointString = attribute.substring(attribute.indexOf("((") + 2, attribute.indexOf("))"));
        String[] cPointStrings = cPointString.split(Pattern.quote("),("));
        for (String s : cPointStrings) {
            String[] cPointPartStrings = s.split(",");
            List<Integer> cPointPartList = new ArrayList<>();
            for (String cPart : cPointPartStrings) {
                cPointPartList.add(Integer.parseInt(cPart.replace("#", "")));
            }
            controlPoints.add(cPointPartList);
        }
        String secondPart = attribute.substring(attribute.indexOf("))") + 3);
        String[] secondParts = secondPart.substring(0, secondPart.indexOf("(")).split(",");
        surfaceForm = BSplineSurfaceForm.valueOf(secondParts[0].replace(".", ""));
        uClosed = secondParts[1].contains("T");
        vClosed = secondParts[2].contains("T");
        selfIntersect = secondParts[3].contains("T");
        String[] thirdParts = secondPart.substring(secondPart.indexOf("(")).split(Pattern.quote("),"));

        uMultiplicities = new ArrayList<>();
        String[] uMultiplicitiesStrings = thirdParts[0].replace("(", "").split(",");
        for (String s : uMultiplicitiesStrings) {
            uMultiplicities.add(Integer.parseInt(s));
        }

        vMultiplicities = new ArrayList<>();
        String[] vMultiplicitiesStrings = thirdParts[1].replace("(", "").split(",");
        for (String s : vMultiplicitiesStrings) {
            vMultiplicities.add(Integer.parseInt(s));
        }

        uKnots = new ArrayList<>();
        String[] uKnotsString = thirdParts[2].replace("(", "").split(",");
        for (String s : uKnotsString) {
            uKnots.add(Double.parseDouble(s));
        }

        vKnots = new ArrayList<>();
        String[] vKnotsString = thirdParts[3].replace("(", "").split(",");
        for (String s : vKnotsString) {
            vKnots.add(Double.parseDouble(s));
        }
        knotType = KnotType.valueOf(thirdParts[4].replace(".", ""));
    }

    @Override
    public String toString() {
        return "BSplineSurfaceWithKnots{" + super.toString() +
                " uDegree=" + uDegree +
                ", vDegree=" + vDegree +
                ", controlPoints=" + controlPoints +
                ", surfaceForm=" + surfaceForm +
                ", uClosed=" + uClosed +
                ", vClosed=" + vClosed +
                ", selfIntersect=" + selfIntersect +
                ", uMultiplicities=" + uMultiplicities +
                ", vMultiplicities=" + vMultiplicities +
                ", uKnots=" + uKnots +
                ", vKnots=" + vKnots +
                ", knotType=" + knotType +
                '}';
    }
}
