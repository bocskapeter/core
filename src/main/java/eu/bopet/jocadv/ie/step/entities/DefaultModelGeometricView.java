package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.StepEntityBase;

public class DefaultModelGeometricView extends StepEntityBase {
    private final String description;
    private final int item;
    private final int rep;
    private final String shapeName;
    private final String shapeDescription;
    private final int shape;
    private final String productDefinitional;

    public DefaultModelGeometricView(int id, String name, String attributes) {
        super(id, name);
        String[] parts = attributes.split(",");
        description = parts[0].replace("'", "");
        item = Integer.parseInt(parts[1].replace("#", ""));
        rep = Integer.parseInt(parts[2].replace("#", ""));
        shapeName = parts[3].replace("'", "");
        shapeDescription = parts[4].replace("'", "");
        shape = Integer.parseInt(parts[5].replace("#", ""));
        productDefinitional = parts[6];
    }

    @Override
    public String toString() {
        return "DefaultModelGeometricView{" + super.toString() +
                ", description='" + description + '\'' +
                ", item=" + item +
                ", rep=" + rep +
                ", shapeName='" + shapeName + '\'' +
                ", shapeDescription='" + shapeDescription + '\'' +
                ", shape=" + shape +
                ", productDefinitional='" + productDefinitional + '\'' +
                '}';
    }
}
