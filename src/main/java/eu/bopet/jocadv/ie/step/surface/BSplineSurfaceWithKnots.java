package eu.bopet.jocadv.ie.step.surface;

import eu.bopet.jocadv.ie.step.StepEntityBase;
import eu.bopet.jocadv.ie.step.curve.KnotType;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BSplineSurfaceWithKnots extends StepEntityBase implements Surface {
    private BSplineSurface bSplineSurface;
    private List<Integer> uMultiplicities;
    private List<Integer> vMultiplicities;
    private List<Double> uKnots;
    private List<Double> vKnots;
    private KnotType knotType;

    public BSplineSurfaceWithKnots(int id, String name, boolean fromSet, String attribute) {
        super(id, name);
        if (!fromSet) {
            String secondPart = attribute.substring(attribute.indexOf("))") + 3);
            bSplineSurface = new BSplineSurface(attribute);
            String[] thirdParts = secondPart.substring(secondPart.indexOf("(")).split(Pattern.quote("),"));
            getTheRest(thirdParts);
        } else {
            String[] parts = attribute.split(Pattern.quote("),"));
            getTheRest(parts);
        }

    }

    private void getTheRest(String[] parts) {
        uMultiplicities = new ArrayList<>();
        String[] uMultiplicitiesStrings = parts[0].replace("(", "").split(",");
        for (String s : uMultiplicitiesStrings) {
            uMultiplicities.add(Integer.parseInt(s));
        }
        vMultiplicities = new ArrayList<>();
        String[] vMultiplicitiesStrings = parts[1].replace("(", "").split(",");
        for (String s : vMultiplicitiesStrings) {
            vMultiplicities.add(Integer.parseInt(s));
        }
        uKnots = new ArrayList<>();
        String[] uKnotsString = parts[2].replace("(", "").split(",");
        for (String s : uKnotsString) {
            uKnots.add(Double.parseDouble(s));
        }
        vKnots = new ArrayList<>();
        String[] vKnotsString = parts[3].replace("(", "").split(",");
        for (String s : vKnotsString) {
            vKnots.add(Double.parseDouble(s));
        }
        knotType = KnotType.valueOf(parts[4].replace(".", ""));
    }

    @Override
    public String toString() {
        return "BSplineSurfaceWithKnots{" + super.toString() +
                ", " + bSplineSurface +
                ", uMultiplicities=" + uMultiplicities +
                ", vMultiplicities=" + vMultiplicities +
                ", uKnots=" + uKnots +
                ", vKnots=" + vKnots +
                ", knotType=" + knotType +
                '}';
    }
}
