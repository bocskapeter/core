package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntityBase;

public class DateTimeRole extends StepEntityBase {
    public DateTimeRole(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "DateTimeRole{" + super.toString() + "}";
    }
}
