package eu.bopet.jocadv.ie.step;

public class Axis2Placement2D extends StepEntity {
    private int locationId;
    private int referenceDirectionId;

    public Axis2Placement2D(int locationId, int referenceDirectionId) {
        this.locationId = locationId;
        this.referenceDirectionId = referenceDirectionId;
    }

    public static Axis2Placement2D getInstance(int id, String name, String attribute) {
        String[] values = attribute.split(",");
        int locationId = Integer.parseInt(values[0].substring(1));
        int refDirectionId = Integer.parseInt(values[1].substring(1));
        Axis2Placement2D axis2Placement2D = new Axis2Placement2D(locationId, refDirectionId);
        axis2Placement2D.setId(id);
        axis2Placement2D.setName(name);
        return axis2Placement2D;
    }

    @Override
    public String toString() {
        return "Axis2Placement2D{" + super.toString() +
                " locationId=" + locationId +
                ", referenceDirectionId=" + referenceDirectionId +
                '}';
    }
}
