package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.measure.Measure;
import eu.bopet.jocadv.ie.step.measure.MeasureValue;
import eu.bopet.jocadv.ie.step.util.StepEntityBase;

public class MeasureRepresentationItem extends StepEntityBase implements Measure {
    private MeasureValue valueComponent;
    private int unit;

    public MeasureRepresentationItem(int id, String name, String attribute) {
        super(id, name);
        String[] parts = attribute.split(",");
        if (parts.length > 1) {
            valueComponent = new MeasureValue(parts[0]);
            unit = Integer.parseInt(parts[1].replace("#", ""));
        }
    }

    @Override
    public String toString() {
        return "MeasureRepresentationItem{" + super.toString() +
                ", valueComponent=" + valueComponent +
                ", unit=" + unit +
                '}';
    }
}