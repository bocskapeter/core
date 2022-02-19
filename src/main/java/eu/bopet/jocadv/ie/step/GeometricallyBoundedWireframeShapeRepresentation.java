package eu.bopet.jocadv.ie.step;

import java.util.Set;

public class GeometricallyBoundedWireframeShapeRepresentation extends StepEntity {
    private Set<Integer> items;
    private int context;

    public GeometricallyBoundedWireframeShapeRepresentation(Set<Integer> items, int context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public String toString() {
        return "GeometricallyBoundedWireframeShapeRepresentation{" + super.toString() +
                " items=" + items +
                ", context=" + context +
                '}';
    }
}
