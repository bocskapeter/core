package eu.bopet.jocadv.ie.step.curve;

import eu.bopet.jocadv.ie.step.util.KnotType;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BSplineCurveWithKnots extends Curve {
    private List<Integer> knotMultiplicities;
    private List<Double> knots;
    private KnotType knotType;

    public BSplineCurveWithKnots(String attributes) {
        knotMultiplicities = new ArrayList<>();
        knots = new ArrayList<>();
        String[] parts = attributes.split(Pattern.quote("),"));
        String[] knotMString = parts[0].replace("(", "").replace(")", "")
                .split(",");
        for (String s : knotMString) {
            int knotM = Integer.parseInt(s);
            knotMultiplicities.add(knotM);
        }
        String[] knotStrings = parts[1].replace("(", "").replace(")", "")
                .split(",");
        for (String s : knotStrings) {
            double knot = Double.parseDouble(s);
            knots.add(knot);
        }
        knotType = KnotType.valueOf(parts[2].replace("(", "").replace(")", "")
                .replace(".", ""));
    }

    @Override
    public String toString() {
        return "BSplineCurveWithKnots{" +
                "knotMultiplicities=" + knotMultiplicities +
                ", knots=" + knots +
                ", knotType=" + knotType +
                '}';
    }
}
