package eu.bopet.jocadv.ie.step.measure;

import eu.bopet.jocadv.ie.step.StepEntityBase;

public class MassMeasureWithUnit extends StepEntityBase {
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
