package eu.bopet.jocadv.ie.step;

public class Plane extends StepEntity {
    private int axis2Placement3DId;

    public Plane(int axis2Placement3DId) {
        this.axis2Placement3DId = axis2Placement3DId;
    }

    @Override
    public String toString() {
        return "Plane{" + super.toString() +
                " axis2Placement3DId=" + axis2Placement3DId +
                '}';
    }
}
