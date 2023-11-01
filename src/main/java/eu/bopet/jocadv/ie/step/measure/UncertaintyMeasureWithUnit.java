package eu.bopet.jocadv.ie.step.measure;

import eu.bopet.jocadv.ie.step.StepEntity;

public class UncertaintyMeasureWithUnit extends StepEntity {
    private MeasureWithUnitInSet measureWithUnitInSet;
    private String description;

    public UncertaintyMeasureWithUnit(int id, String name, String attribute) {
        super(id, name);
        String[] parts = attribute.split(",");
        measureWithUnitInSet = new MeasureWithUnitInSet(parts[0] + "," + parts[1]);
        this.setName(parts[2].replace("'", "").replace(" ", ""));
        description = parts[3].replace("'", "");
    }

    @Override
    public String toString() {
        return "UncertaintyMeasureWithUnit{" + super.toString() +
                ", measureWithUnit=" + measureWithUnitInSet +
                ", description='" + description + '\'' +
                '}';
    }
}
