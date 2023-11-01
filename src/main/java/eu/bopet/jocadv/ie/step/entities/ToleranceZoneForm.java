package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntity;

public class ToleranceZoneForm extends StepEntity {
    public ToleranceZoneForm(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "ToleranceZoneForm{" + super.toString() + "}";
    }
}
