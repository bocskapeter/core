package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.shapeAspect.ShapeAspect;
import eu.bopet.jocadv.ie.step.util.UtilStringInt;

public class DatumFeature extends UtilStringInt implements ShapeAspect {
    private final boolean productDefinitional;

    public DatumFeature(int id, String name, String attribute) {
        super(id, name, attribute);
        if (!attribute.isEmpty())
            productDefinitional = attribute.substring(attribute.lastIndexOf(",")).contains("T");
        else productDefinitional = false;
    }

    @Override
    public String toString() {
        return "DatumFeature{" + super.toString() +
                ", productDefinitional=" + productDefinitional +
                '}';
    }
}
