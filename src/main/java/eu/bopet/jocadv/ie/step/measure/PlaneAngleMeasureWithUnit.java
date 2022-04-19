package eu.bopet.jocadv.ie.step.measure;

import eu.bopet.jocadv.ie.step.util.StepEntityBase;

public class PlaneAngleMeasureWithUnit extends StepEntityBase {
    private MeasureWithUnitInSet measureWithUnitInSet;

    public PlaneAngleMeasureWithUnit(int id, String name, String attribute) {
        super(id, name);
        measureWithUnitInSet = new MeasureWithUnitInSet(attribute);
    }

    @Override
    public String toString() {
        return "PlaneAngleMeasureWithUnit{" + measureWithUnitInSet + '}';
    }
}
