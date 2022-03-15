package eu.bopet.jocadv.ie.step.measure;

import eu.bopet.jocadv.ie.step.util.StepEntityBase;

public class PlaneAngleMeasureWithUnit extends StepEntityBase {
    private MeasureWithUnit measureWithUnit;

    public PlaneAngleMeasureWithUnit(int id, String name, String attribute) {
        super(id, name);
        measureWithUnit = new MeasureWithUnit(attribute);
    }

    @Override
    public String toString() {
        return "PlaneAngleMeasureWithUnit{" + measureWithUnit + '}';
    }
}
