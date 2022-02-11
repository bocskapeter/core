package eu.bopet.jocadv.ie.step;

public class CylindricalSurface extends StepEntity {
    private int positionId;
    private double radius;

    public CylindricalSurface(int positionId, double radius) {
        this.positionId = positionId;
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "CylindricalSurface{" + super.toString() +
                " positionId=" + positionId +
                ", radius=" + radius +
                '}';
    }
}
