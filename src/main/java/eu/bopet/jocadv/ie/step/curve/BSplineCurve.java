package eu.bopet.jocadv.ie.step.curve;

import java.util.ArrayList;
import java.util.List;

public class BSplineCurve implements Curve {
    private int degree;
    private List<Integer> controlPointIds;
    private BSplineCurveForm curveForm;
    private boolean closed;
    private boolean selfIntersect;

    public BSplineCurve(String attributes) {
        controlPointIds = new ArrayList<>();
        degree = Integer.parseInt(attributes.substring(0, attributes.indexOf(",")));
        String[] cPointString = attributes.substring(attributes.indexOf("(") + 1, attributes.indexOf(")"))
                .split(",");
        for (String s : cPointString) {
            int id = Integer.parseInt(s.replace("#", ""));
            controlPointIds.add(id);
        }
        String[] rest = attributes.substring(attributes.indexOf(")") + 2).split(",");
        curveForm = BSplineCurveForm.valueOf(rest[0].replace(".", ""));
        closed = rest[1].contains("T");
        selfIntersect = rest[2].contains("T");
    }

    @Override
    public String toString() {
        return "BSplineCurve{" +
                "degree=" + degree +
                ", controlPointIds=" + controlPointIds +
                ", curveForm=" + curveForm +
                ", closed=" + closed +
                ", selfIntersect=" + selfIntersect +
                '}';
    }
}
