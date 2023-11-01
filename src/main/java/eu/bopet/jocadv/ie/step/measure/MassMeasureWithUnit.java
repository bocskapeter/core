package eu.bopet.jocadv.ie.step.measure;

import eu.bopet.jocadv.ie.step.StepEntity;

public class MassMeasureWithUnit extends StepEntity {
    private MeasureWithUnitInSet measure;

    public MassMeasureWithUnit(int id, String name, String attribute) {
        super(id, name);
        measure = new MeasureWithUnitInSet(attribute);
    }

    @Override
    public String toString() {
        return "MassMeasureWithUnit{" + super.toString() +
                ", " + measure +
                '}';
    }
}
