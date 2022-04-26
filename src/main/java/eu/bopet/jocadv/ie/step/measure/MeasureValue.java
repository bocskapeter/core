package eu.bopet.jocadv.ie.step.measure;

public class MeasureValue {
    private MeasureValueComponent measure;
    private double value = Double.NaN;

    public MeasureValue(String attribute) {
        if (!attribute.isEmpty()) {
            measure = MeasureValueComponent.valueOf(attribute.substring(0, attribute.indexOf("(")));
            value = Double.parseDouble(attribute.substring(attribute.indexOf("(") + 1, attribute.indexOf(")")));
        }
    }

    @Override
    public String toString() {
        return "{" + measure +
                "=" + value +
                '}';
    }
}
