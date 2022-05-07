package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntityBase;

public class ToleranceZoneForm extends StepEntityBase {
    public ToleranceZoneForm(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "ToleranceZoneForm{" + super.toString() + "}";
    }
}
