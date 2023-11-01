package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntity;

public class SecurityClassificationLevel extends StepEntity {
    public SecurityClassificationLevel(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "SecurityClassificationLevel{" + super.toString() + "}";
    }
}
