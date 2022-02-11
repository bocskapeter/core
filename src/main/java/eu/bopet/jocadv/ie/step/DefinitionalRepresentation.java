package eu.bopet.jocadv.ie.step;

import java.util.Set;

public class DefinitionalRepresentation extends StepEntity {
    private Set<Integer> itemIds;
    private int contextId;

    public DefinitionalRepresentation(Set<Integer> itemIds, int contextId) {
        this.itemIds = itemIds;
        this.contextId = contextId;
    }

    @Override
    public String toString() {
        return "DefinitionalRepresentation{" + super.toString() +
                " itemIds=" + itemIds +
                ", contextId=" + contextId +
                '}';
    }
}
