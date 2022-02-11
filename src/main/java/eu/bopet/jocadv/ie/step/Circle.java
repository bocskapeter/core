package eu.bopet.jocadv.ie.step;

public class Circle extends StepEntity {
    private int positionId;
    private double radius;

    public Circle(int positionId, double radius) {
        this.positionId = positionId;
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" + super.toString() +
                " positionId=" + positionId +
                ", radius=" + radius +
                '}';
    }
}
