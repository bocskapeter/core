package eu.bopet.jocadv.ie.step.measure;

import eu.bopet.jocadv.ie.step.util.StepCode;
import eu.bopet.jocadv.ie.step.util.StepEntityBase;

public class MeasureWithUnit extends StepEntityBase {
    private LengthMeasureWithUnit lengthMeasureWithUnit;

    public MeasureWithUnit(int id, String name, String attribute) {
        super(id, name);
        if (attribute.startsWith(StepCode.LENGTH_MEASURE)) {
            lengthMeasureWithUnit = new LengthMeasureWithUnit(-1, "", attribute);
        }
    }

    @Override
    public String toString() {
        return "MeasureWithUnit{" + super.toString() +
                ", lengthMeasureWithUnit=" + lengthMeasureWithUnit +
                '}';
    }
}
