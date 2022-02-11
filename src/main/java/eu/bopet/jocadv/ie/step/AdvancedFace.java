package eu.bopet.jocadv.ie.step;

import java.util.Set;

public class AdvancedFace extends StepEntity {
    private Set<Integer> boundIds;
    private int surfaceId;
    private boolean sameSense;

    public AdvancedFace(Set<Integer> boundIds, int surfaceId, boolean sameSense) {
        this.boundIds = boundIds;
        this.surfaceId = surfaceId;
        this.sameSense = sameSense;
    }

    @Override
    public String toString() {
        return "AdvancedFace{" + super.toString() +
                " boundIds=" + boundIds +
                ", surfaceId=" + surfaceId +
                ", sameSense=" + sameSense +
                '}';
    }
}
