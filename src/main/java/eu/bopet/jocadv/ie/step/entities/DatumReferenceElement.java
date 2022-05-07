package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntityBase;

public class DatumReferenceElement extends StepEntityBase {
    private final String description;
    private final int shape;
    private final boolean productDefinitional;
    private final int base;
    private final String modifiers;

    public DatumReferenceElement(int id, String name, String attribute) {
        super(id, name);
        String[] parts = attribute.split(",");
        description = parts[0];
        shape = Integer.parseInt(parts[1].replace("#", ""));
        productDefinitional = parts[2].contains("T");
        base = Integer.parseInt(parts[3].replace("#", ""));
        modifiers = parts[4];
        // TODO - process modifiers
    }

    @Override
    public String toString() {
        return "DatumReferenceElement{" + super.toString() +
                ", description='" + description + '\'' +
                ", shape=" + shape +
                ", productDefinitional=" + productDefinitional +
                ", base=" + base +
                ", modifiers='" + modifiers + '\'' +
                '}';
    }
}
