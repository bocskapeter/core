package eu.bopet.jocadv.ie.step.surface;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class RationalBSplineSurface implements Surface {
    List<List<Double>> weights;

    public RationalBSplineSurface(String attribute) {
        String[] parts = attribute.split(Pattern.quote("),("));
        weights = new ArrayList<>();
        for (String s : parts) {
            List<Double> weight = new ArrayList<>();
            String[] subParts = s.replace("(", "").replace(")", "").split(",");
            for (String subString : subParts) {
                weight.add(Double.parseDouble(subString));
            }
            weights.add(weight);
        }
    }

    @Override
    public String toString() {
        return "RationalBSplineSurface{" +
                "weights=" + weights +
                '}';
    }
}
