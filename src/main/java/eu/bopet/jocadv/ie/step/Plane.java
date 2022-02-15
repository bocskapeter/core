package eu.bopet.jocadv.ie.step;

public class Plane extends StepEntity {
    private int axis2Placement3DId;

    public Plane(int axis2Placement3DId) {
        this.axis2Placement3DId = axis2Placement3DId;
    }

    public static Plane getInstance(int id, String name, String attribute) {
        int axis2Placement3DId = Integer.parseInt(attribute.substring(1));
        Plane plane = new Plane(axis2Placement3DId);
        plane.setId(id);
        plane.setName(name);
        return plane;
    }

    @Override
    public String toString() {
        return "Plane{" + super.toString() +
                " axis2Placement3DId=" + axis2Placement3DId +
                '}';
    }
}
