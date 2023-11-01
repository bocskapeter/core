package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntity;

public class PreDefinedMarker extends StepEntity {
    public PreDefinedMarker(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "PreDefinedMarker{" + super.toString() + "}";
    }
}
