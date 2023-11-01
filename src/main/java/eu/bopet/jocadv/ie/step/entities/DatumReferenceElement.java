package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntity;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class DatumReferenceElement extends StepEntity {
    private final String description;
    private final int shape;
    private final boolean productDefinitional;
    private final int base;
    private final String modifiers;

    public DatumReferenceElement(int id, String name, String attribute) {
        super(id, name);
        String[] parts = attribute.split(",");
        description = parts[0];
        String shapeString = parts[1].replace("#", "");
        if (isNumeric(shapeString))
            shape = Integer.parseInt(shapeString);
        else shape = -1;
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
