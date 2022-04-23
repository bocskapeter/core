package eu.bopet.jocadv.ie.step.measure;

public class MeasureWithUnitInSet implements SelectedSize {
    private MeasureValue value;
    private int unit;

    public MeasureWithUnitInSet(String attribute) {
        String[] parts = attribute.split(",");
        value = new MeasureValue(parts[0]);
        unit = Integer.parseInt(parts[1].replace("#", ""));
    }

    @Override
    public String toString() {
        return "MeasureWithUnit{" + value + ", unit=" + unit + '}';
    }
}
