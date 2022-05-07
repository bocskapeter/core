package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntityBase;

public class PlanarBox extends StepEntityBase {
    private final double x;
    private final double y;
    private final int placement;

    public PlanarBox(int id, String name, String attributes) {
        super(id, name);
        String[] parts = attributes.split(",");
        x = Double.parseDouble(parts[0]);
        y = Double.parseDouble(parts[1]);
        placement = Integer.parseInt(parts[2].replace("#", ""));
    }

    @Override
    public String toString() {
        return "PlanarBox{" + super.toString() +
                ", x=" + x +
                ", y=" + y +
                ", placement=" + placement +
                '}';
    }
}
