package eu.bopet.jocadv.ie.step.measure;

public class MeasureWithUnit implements SelectedSize {
    private MeasureValue value;
    private int unit;

    public MeasureWithUnit(String attribute) {
        String[] parts = attribute.split(",");
        value = new MeasureValue(parts[0]);
        unit = Integer.parseInt(parts[1].replace("#", ""));
    }

    @Override
    public String toString() {
        return "MeasureWithUnit{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }
}
