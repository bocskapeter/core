package eu.bopet.jocadv.ie.step.measure;

import eu.bopet.jocadv.ie.step.StepEntityBase;

public class LengthMeasureWithUnit extends StepEntityBase implements Measure {
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
