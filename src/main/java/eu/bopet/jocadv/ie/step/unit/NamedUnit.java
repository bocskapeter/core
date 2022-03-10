package eu.bopet.jocadv.ie.step.unit;

public class NamedUnit implements Unit {
    private String exponents;

    public NamedUnit(String attribute) {
        exponents = attribute;
    }

    @Override
    public String toString() {
        return "NamedUnit{" + exponents + '}';
    }
}
