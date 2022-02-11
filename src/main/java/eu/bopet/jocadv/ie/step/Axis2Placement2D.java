package eu.bopet.jocadv.ie.step;

public class Axis2Placement2D extends StepEntity {
    private int locationId;
    private int referenceDirectionId;

    public Axis2Placement2D(int locationId, int referenceDirectionId) {
        this.locationId = locationId;
        this.referenceDirectionId = referenceDirectionId;
    }

    @Override
    public String toString() {
        return "Axis2Placement2D{" + super.toString() +
                " locationId=" + locationId +
                ", referenceDirectionId=" + referenceDirectionId +
                '}';
    }
}
