package eu.bopet.jocadv.ie.step;

public class Vector extends StepEntity {
    private int directionId;
    private double length;

    public Vector(int directionId, double length) {
        this.directionId = directionId;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Vector{" + super.toString() +
                " directionId=" + directionId +
                ", length=" + length +
                '}';
    }
}
