package eu.bopet.jocadv.ie.step.unit;

public class SIUnit implements Unit {
    private SIPrefix prefix;
    private SIUnitName name;

    public SIUnit(String attribute) {
        String[] parts = attribute.split(",");
        prefix = SIPrefix.valueOf(parts[0].replace(".", ""));
        name = SIUnitName.valueOf(parts[1].replace(".", ""));
    }

    @Override
    public String toString() {
        return "SIUnit{" +
                "prefix=" + prefix +
                ", name=" + name +
                '}';
    }
}
