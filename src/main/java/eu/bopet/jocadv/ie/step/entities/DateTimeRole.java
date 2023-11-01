package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntity;

public class DateTimeRole extends StepEntity {
    public DateTimeRole(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "DateTimeRole{" + super.toString() + "}";
    }
}
