package eu.bopet.jocadv.ie.step.curve;

import eu.bopet.jocadv.ie.step.util.StepEntityBase;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TessellatedCurveSet extends StepEntityBase {
    private final int coordinates;
    private final List<List<Integer>> strips;

    public TessellatedCurveSet(int id, String name, String attribute) {
        super(id, name);
        coordinates = Integer.parseInt(attribute.substring(0, attribute.indexOf(",")).replace("#", ""));
        String[] pairs = attribute.substring(attribute.indexOf(",") + 1).split(Pattern.quote("),("));
        strips = new ArrayList<>();
        for (String pair : pairs) {
            List<Integer> subStrips = new ArrayList<>();
            String[] c = pair.replace("(", "").replace(")", "").split(",");
            for (String s : c) {
                subStrips.add(Integer.parseInt(s));
            }
            strips.add(subStrips);
        }
    }

    @Override
    public String toString() {
        return "TessellatedCurveSet{" + super.toString() +
                ", coordinates=" + coordinates +
                ", strips=" + strips +
                '}';
    }
}
