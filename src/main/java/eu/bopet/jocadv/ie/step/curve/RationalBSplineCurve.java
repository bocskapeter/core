package eu.bopet.jocadv.ie.step.curve;

import java.util.ArrayList;
import java.util.List;

public class RationalBSplineCurve implements Curve {
    private List<Double> weights;

    public RationalBSplineCurve(String attributes) {
        weights = new ArrayList<>();
        String[] weightStrings = attributes.replace("(", "").replace(")", "")
                .split(",");
        for (String s : weightStrings) {
            double weight = Double.parseDouble(s);
            weights.add(weight);
        }
    }

    @Override
    public String toString() {
        return "RationalBSplineCurve{" +
                "weights=" + weights +
                '}';
    }
}
