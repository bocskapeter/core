package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntity;

public class FaceBound extends StepEntity {
    private int loopId;
    private boolean orientation;

    public FaceBound(int id, String name, String attribute) {
        super(id, name);
        String[] values = attribute.split(",");
        loopId = Integer.parseInt(values[0].substring(1));
        orientation = values[1].contains("T");
    }

    @Override
    public String toString() {
        return "FaceBound{" + super.toString() +
                " loopId=" + loopId +
                ", orientation=" + orientation +
                '}';
    }
}
