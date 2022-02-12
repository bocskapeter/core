package eu.bopet.jocadv.ie.step;

public class Ellipse extends StepEntity {
    private int positionId;
    private double axis1;
    private double axis2;

    public Ellipse(int positionId, double axis1, double axis2) {
        this.positionId = positionId;
        this.axis1 = axis1;
        this.axis2 = axis2;
    }

    @Override
    public String toString() {
        return "Ellipse{" + super.toString() +
                " positionId=" + positionId +
                ", axis1=" + axis1 +
                ", axis2=" + axis2 +
                '}';
    }
}
