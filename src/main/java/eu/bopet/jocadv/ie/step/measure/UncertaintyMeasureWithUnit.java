package eu.bopet.jocadv.ie.step.measure;

import eu.bopet.jocadv.ie.step.util.StepEntityBase;

public class UncertaintyMeasureWithUnit extends StepEntityBase {
    private MeasureWithUnit measureWithUnit;
    private String description;

    public UncertaintyMeasureWithUnit(int id, String name, String attribute) {
        super(id, name);
        String[] parts = attribute.split(",");
        measureWithUnit = new MeasureWithUnit(parts[0] + "," + parts[1]);
        this.setName(parts[2].replace("'", "").replace(" ", ""));
        description = parts[3].replace("'", "");
    }

    @Override
    public String toString() {
        return "UncertaintyMeasureWithUnit{" + super.toString() +
                ", measureWithUnit=" + measureWithUnit +
                ", description='" + description + '\'' +
                '}';
    }
}
