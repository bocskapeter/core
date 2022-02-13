package eu.bopet.jocadv.ie.step;

import java.util.Set;

public class AdvancedBRepShapeRepresentation extends StepEntity {
    private Set<Integer> itemIds;
    private int contextId;

    public AdvancedBRepShapeRepresentation(Set<Integer> itemIds, int contextId) {
        this.itemIds = itemIds;
        this.contextId = contextId;
    }

    @Override
    public String toString() {
        return "AdvancedBRepShapeRepresentation{" + super.toString() +
                " itemIds=" + itemIds +
                ", contextId=" + contextId +
                '}';
    }
}
