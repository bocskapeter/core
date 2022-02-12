package eu.bopet.jocadv.ie.step;

public class SurfaceOfLinearExtrusion extends StepEntity {
    private int curveId;
    private int axisId;

    public SurfaceOfLinearExtrusion(int curveId, int axisId) {
        this.curveId = curveId;
        this.axisId = axisId;
    }

    @Override
    public String toString() {
        return "SurfaceOfLinearExtrusion{" + super.toString() +
                " curveId=" + curveId +
                ", axisId=" + axisId +
                '}';
    }
}
