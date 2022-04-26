package eu.bopet.jocadv.ie.step.measure;

public class MeasureWithUnitInSet implements SelectedSize, Measure {
    private MeasureValue value;
    private int unit = -1;

    public MeasureWithUnitInSet(String attribute) {
        String[] parts = attribute.split(",");
        if (parts.length > 1) {
            value = new MeasureValue(parts[0]);
            unit = Integer.parseInt(parts[1].replace("#", ""));
        }
    }

    @Override
    public String toString() {
        return "MeasureWithUnit{" + value + ", unit=" + unit + '}';
    }
}
