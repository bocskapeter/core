package eu.bopet.jocadv.ie.step.measure;

import eu.bopet.jocadv.ie.step.StepEntity;

public class PlaneAngleMeasureWithUnit extends StepEntity implements Measure {
    private final MeasureWithUnitInSet measureWithUnitInSet;

    public PlaneAngleMeasureWithUnit(int id, String name, String attribute) {
        super(id, name);
        if (!attribute.isEmpty()) {
            measureWithUnitInSet = new MeasureWithUnitInSet(attribute);
        } else {
            measureWithUnitInSet = null;
        }
    }

    @Override
    public String toString() {
        return "PlaneAngleMeasureWithUnit{" + measureWithUnitInSet + '}';
    }
}
