package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntityBase;

public class AllAroundShapeAspect extends StepEntityBase {
    private final String description;
    private final int shape;
    private final boolean producltDefinitional;

    public AllAroundShapeAspect(int id, String name, String attributes) {
        super(id, name);
        String[] parts = attributes.split(",");
        description = parts[0].replace("'", "");
        shape = Integer.parseInt(parts[1].replace("#", ""));
        producltDefinitional = parts[2].contains("T");
    }

    @Override
    public String toString() {
        return "AllAroundShapeAspect{" + super.toString() +
                ", description='" + description + '\'' +
                ", shape=" + shape +
                ", producltDefinitional=" + producltDefinitional +
                '}';
    }
}
