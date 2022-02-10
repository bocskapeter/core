package eu.bopet.jocadv.ie.step;

public class PCurve extends StepEntity {
    private int basisSurfaceId;
    private int referenceToCurveId;

    public PCurve(int basisSurfaceId, int referenceToCurveId) {
        this.basisSurfaceId = basisSurfaceId;
        this.referenceToCurveId = referenceToCurveId;
    }

    @Override
    public String toString() {
        return "PCurve{" + super.toString() +
                " basisSurfaceId=" + basisSurfaceId +
                ", referenceToCurveId=" + referenceToCurveId +
                '}';
    }
}
