package eu.bopet.jocadv.ie.step;

public class SurfaceOfLinearExtrusion extends StepEntity {
    private int curveId;
    private int axisId;

    public SurfaceOfLinearExtrusion(int curveId, int axisId) {
        this.curveId = curveId;
        this.axisId = axisId;
    }

    public static SurfaceOfLinearExtrusion getInstance(int id, String name, String attribute) {
        String[] values = attribute.split(",");
        int curveId = Integer.parseInt(values[0].substring(1));
        int axisId = Integer.parseInt(values[1].substring(1));
        SurfaceOfLinearExtrusion surfaceOfLinearExtrusion =
                new SurfaceOfLinearExtrusion(curveId, axisId);
        surfaceOfLinearExtrusion.setId(id);
        surfaceOfLinearExtrusion.setName(name);
        return surfaceOfLinearExtrusion;
    }

    @Override
    public String toString() {
        return "SurfaceOfLinearExtrusion{" + super.toString() +
                " curveId=" + curveId +
                ", axisId=" + axisId +
                '}';
    }
}
