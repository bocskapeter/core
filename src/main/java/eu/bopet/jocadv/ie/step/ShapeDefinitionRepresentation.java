package eu.bopet.jocadv.ie.step;

public class ShapeDefinitionRepresentation extends StepEntity {
    private int definition;
    private int representationId;

    public ShapeDefinitionRepresentation(int definition, int representationId) {
        this.definition = definition;
        this.representationId = representationId;
    }

    public static ShapeDefinitionRepresentation getInstance(int id, String name, String attribute) {
        String[] values = attribute.split(",");
        int definition = Integer.parseInt(name.substring(1));
        int representationId = Integer.parseInt(values[0].substring(1));
        ShapeDefinitionRepresentation shapeDefinitionRepresentation =
                new ShapeDefinitionRepresentation(definition, representationId);
        shapeDefinitionRepresentation.setId(id);
        return shapeDefinitionRepresentation;
    }

    @Override
    public String toString() {
        return "ShapeDefinitionRepresentation{" + super.toString() +
                " definition=" + definition +
                ", representationId=" + representationId +
                '}';
    }
}
