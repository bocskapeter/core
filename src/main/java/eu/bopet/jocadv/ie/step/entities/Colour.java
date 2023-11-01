package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntity;

public class Colour extends StepEntity {
    public Colour(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Colour{" + super.toString() + "}";
    }
}
