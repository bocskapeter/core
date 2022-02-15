package eu.bopet.jocadv.ie.step;

public class PCurve extends StepEntity {
    private int basisSurfaceId;
    private int referenceToCurveId;

    public PCurve(int basisSurfaceId, int referenceToCurveId) {
        this.basisSurfaceId = basisSurfaceId;
        this.referenceToCurveId = referenceToCurveId;
    }

    public static PCurve getInstance(int id, String name, String attributes) {
        String[] values = attributes.split(",");
        int basisSurfaceId = Integer.parseInt(values[0].substring(1));
        int referenceToCurveId = Integer.parseInt(values[1].substring(1));
        PCurve pCurve = new PCurve(basisSurfaceId, referenceToCurveId);
        pCurve.setId(id);
        pCurve.setName(name);
        return pCurve;
    }

    @Override
    public String toString() {
        return "PCurve{" + super.toString() +
                " basisSurfaceId=" + basisSurfaceId +
                ", referenceToCurveId=" + referenceToCurveId +
                '}';
    }
}
