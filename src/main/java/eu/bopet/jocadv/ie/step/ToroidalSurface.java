package eu.bopet.jocadv.ie.step;

public class ToroidalSurface extends StepEntity {
    private int positionId;
    private double majorRadius;
    private double minorRadius;

    public ToroidalSurface(int positionId, double majorRadius, double minorRadius) {
        this.positionId = positionId;
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    @Override
    public String toString() {
        return "ToroidalSurface{" + super.toString() +
                " positionId=" + positionId +
                ", majorRadius=" + majorRadius +
                ", minorRadius=" + minorRadius +
                '}';
    }
}
