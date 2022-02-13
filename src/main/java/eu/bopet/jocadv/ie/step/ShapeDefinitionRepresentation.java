package eu.bopet.jocadv.ie.step;

public class ShapeDefinitionRepresentation extends StepEntity {
    private int definition;
    private int representationId;

    public ShapeDefinitionRepresentation(int definition, int representationId) {
        this.definition = definition;
        this.representationId = representationId;
    }

    @Override
    public String toString() {
        return "ShapeDefinitionRepresentation{" + super.toString() +
                " definition=" + definition +
                ", representationId=" + representationId +
                '}';
    }
}
