package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.measure.MeasureValue;
import eu.bopet.jocadv.ie.step.StepEntityBase;

public class ValueRepresentationItem extends StepEntityBase {
    private MeasureValue valueComponent;

    public ValueRepresentationItem(int id, String name, String attribute) {
        super(id, name);
        valueComponent = new MeasureValue(attribute);
    }

    @Override
    public String toString() {
        return "ValueRepresentationItem{" + super.toString() +
                ", valueComponent=" + valueComponent +
                '}';
    }
}
