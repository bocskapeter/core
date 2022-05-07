package eu.bopet.jocadv.ie.step.measure;

import eu.bopet.jocadv.ie.step.StepEntityBase;

public class PlaneAngleMeasureWithUnit extends StepEntityBase implements Measure {
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
