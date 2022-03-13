package eu.bopet.jocadv.ie.step.measure;

public class PositiveLengthMeasure implements SelectedSize {
    private double value;

    public PositiveLengthMeasure(String attribute) {
        value = Double.parseDouble(attribute);
    }

    @Override
    public String toString() {
        return "PositiveLengthMeasure{" +
                "value=" + value +
                '}';
    }
}
