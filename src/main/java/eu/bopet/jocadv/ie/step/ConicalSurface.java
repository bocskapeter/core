package eu.bopet.jocadv.ie.step;

public class ConicalSurface extends StepEntity {
    private int positionId;
    private double radius;
    private double angle;

    public ConicalSurface(int positionId, double radius, double angle) {
        this.positionId = positionId;
        this.radius = radius;
        this.angle = angle;
    }

    @Override
    public String toString() {
        return "ConicalSurface{" + super.toString() +
                " positionId=" + positionId +
                ", radius=" + radius +
                ", angle=" + angle +
                '}';
    }
}
