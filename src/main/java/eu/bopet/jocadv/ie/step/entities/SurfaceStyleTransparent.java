package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.StepEntityBase;

public class SurfaceStyleTransparent extends StepEntityBase {
    private double value;

    public SurfaceStyleTransparent(int id, String name, String attribute) {
        super(id, name);
        value = Double.parseDouble(attribute);
    }

    @Override
    public String toString() {
        return "SurfaceStyleTransparent{" + super.toString() +
                ", value=" + value +
                '}';
    }
}
