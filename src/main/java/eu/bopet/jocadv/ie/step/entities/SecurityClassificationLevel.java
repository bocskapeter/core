package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.StepEntityBase;

public class SecurityClassificationLevel extends StepEntityBase {
    public SecurityClassificationLevel(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "SecurityClassificationLevel{" + super.toString() + "}";
    }
}
