package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringInt;

public class DatumFeature extends UtilStringInt {
    private final boolean productDefinitional;

    public DatumFeature(int id, String name, String attribute) {
        super(id, name, attribute);
        productDefinitional = attribute.substring(attribute.lastIndexOf(",")).contains("T");
    }

    @Override
    public String toString() {
        return "DatumFeature{" + super.toString() +
                ", productDefinitional=" + productDefinitional +
                '}';
    }
}
