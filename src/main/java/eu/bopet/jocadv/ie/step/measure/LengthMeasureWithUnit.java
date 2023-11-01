package eu.bopet.jocadv.ie.step.measure;

import eu.bopet.jocadv.ie.step.StepEntity;

public class LengthMeasureWithUnit extends StepEntity implements Measure {
    private MeasureWithUnitInSet measureWithUnitInSet;

    public LengthMeasureWithUnit(int id, String name, String attribute) {
        super(id, name);
        measureWithUnitInSet = new MeasureWithUnitInSet(attribute);
    }

    @Override
    public String toString() {
        return "LengthMeasureWithUnit{" + measureWithUnitInSet + '}';
    }
}
