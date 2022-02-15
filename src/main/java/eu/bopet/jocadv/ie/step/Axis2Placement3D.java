package eu.bopet.jocadv.ie.step;

public class Axis2Placement3D extends StepEntity {
    private int locationId;
    private int axisId;
    private int referenceDirectionId;

    public Axis2Placement3D(int locationId, int axisId, int referenceDirectionId) {
        this.locationId = locationId;
        this.axisId = axisId;
        this.referenceDirectionId = referenceDirectionId;
    }

    public static Axis2Placement3D getInstance(int id, String name, String attributes) {
        String[] values = attributes.split(",");
        int locationId = Integer.parseInt(values[0].substring(1));
        int axisId = Integer.parseInt(values[1].substring(1));
        int refDirectionId = Integer.parseInt(values[2].substring(1));
        Axis2Placement3D axis2Placement3D = new Axis2Placement3D(locationId, axisId, refDirectionId);
        axis2Placement3D.setId(id);
        axis2Placement3D.setName(name);
        return axis2Placement3D;
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
