package eu.bopet.jocadv.ie.step.entities;

public class ParameterValue implements SelectedTrim {
    private double value;

    public ParameterValue(String attribute) {
        value = Double.parseDouble(attribute);
    }

    @Override
    public String toString() {
        return "ParameterValue{" +
                "value=" + value +
                '}';
    }
}
