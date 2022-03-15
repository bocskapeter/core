package eu.bopet.jocadv.ie.step.measure;

import eu.bopet.jocadv.ie.step.util.StepEntityBase;

public class LengthMeasureWithUnit extends StepEntityBase {
    private MeasureWithUnit measureWithUnit;

    public LengthMeasureWithUnit(int id, String name, String attribute) {
        super(id, name);
        measureWithUnit = new MeasureWithUnit(attribute);
    }

    @Override
    public String toString() {
        return "LengthMeasureWithUnit{" + measureWithUnit + '}';
    }
}
