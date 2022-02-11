package eu.bopet.jocadv.ie.step;

import java.util.Set;

public class ClosedShell extends StepEntity {
    private Set<Integer> faceIds;

    public ClosedShell(Set<Integer> faceIds) {
        this.faceIds = faceIds;
    }

    @Override
    public String toString() {
        return "ClosedShell{" + super.toString() +
                " faceIds=" + faceIds +
                '}';
    }
}
