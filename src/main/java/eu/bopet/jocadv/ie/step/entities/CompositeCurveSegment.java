package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntity;

public class CompositeCurveSegment extends StepEntity {
    private TransitionCode transition;
    private boolean sameSense;
    private int curve;

    public CompositeCurveSegment(int id, String name, String attribute) {
        super(id, name);
        String[] parts = attribute.split(",");
        transition = TransitionCode.valueOf(parts[0].replace(".", ""));
        sameSense = parts[1].contains("T");
        curve = Integer.parseInt(parts[2].replace("#", ""));
    }

    @Override
    public String toString() {
        return "CompositeCurveSegment{" + super.toString() +
                ", transition=" + transition +
                ", sameSense=" + sameSense +
                ", curve=" + curve +
                '}';
    }
}
