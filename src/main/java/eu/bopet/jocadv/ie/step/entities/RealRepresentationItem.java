package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntity;

public class RealRepresentationItem extends StepEntity {
    private double value;

    public RealRepresentationItem(int id, String name, String attribute) {
        super(id, name);
        value = Double.parseDouble(attribute);
    }

    @Override
    public String toString() {
        return "RealRepresentationItem{" + super.toString() +
                ", value=" + value +
                '}';
    }
}
