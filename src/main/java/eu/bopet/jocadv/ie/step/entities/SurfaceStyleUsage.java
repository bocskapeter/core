package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntity;

public class SurfaceStyleUsage extends StepEntity {
    private SurfaceSide side;
    private int style;

    public SurfaceStyleUsage(int id, String name, String attribute) {
        super(id, name);
        String[] parts = attribute.split(",");
        side = SurfaceSide.valueOf(parts[0].replace(".", ""));
        style = Integer.parseInt(parts[1].replace("#", ""));
    }

    @Override
    public String toString() {
        return "SurfaceStyleUsage{" + super.toString() +
                ", side=" + side +
                ", style=" + style +
                '}';
    }
}
