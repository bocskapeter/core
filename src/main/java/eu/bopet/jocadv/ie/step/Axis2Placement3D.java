package eu.bopet.jocadv.ie.step;

public class Axis2Placement3D extends StepEntity{
    private int locationId;
    private int axisId;
    private int referenceDirectionId;

    public Axis2Placement3D(int locationId, int axisId, int referenceDirectionId) {
        this.locationId = locationId;
        this.axisId = axisId;
        this.referenceDirectionId = referenceDirectionId;
    }

    @Override
    public String toString() {
        return "Axis2Placement3D{" + super.toString() +
                " locationId=" + locationId +
                ", axisId=" + axisId +
                ", referenceDirectionId=" + referenceDirectionId +
                '}';
    }
}
