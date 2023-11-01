package eu.bopet.jocadv.ie.step.measure;

import eu.bopet.jocadv.ie.step.StepEntity;
import eu.bopet.jocadv.ie.step.util.StepCode;

public class MeasureWithUnit extends StepEntity implements Measure {
    private Measure measure;

    public MeasureWithUnit(int id, String name, String attribute) {
        super(id, name);
        if (attribute.startsWith(StepCode.LENGTH_MEASURE)) {
            measure = new LengthMeasureWithUnit(-1, "", attribute);
        }
        if (attribute.startsWith(StepCode.PLANE_ANGLE_MEASURE)) {
            measure = new PlaneAngleMeasureWithUnit(-1, "", attribute);
        }
    }

    @Override
    public String toString() {
        return "MeasureWithUnit{" + super.toString() + measure + '}';
    }
}
