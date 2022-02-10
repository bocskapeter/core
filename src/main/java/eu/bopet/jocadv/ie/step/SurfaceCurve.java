package eu.bopet.jocadv.ie.step;

import java.util.List;

public class SurfaceCurve extends StepEntity {
    private int curveId;
    private List<Integer> associatedGeometry;
    private PreferredSurfaceCurveRepresentation masterRepresentation;

    public SurfaceCurve(int curveId, List<Integer> associatedGeometry, PreferredSurfaceCurveRepresentation masterRepresentation) {
        this.curveId = curveId;
        this.associatedGeometry = associatedGeometry;
        this.masterRepresentation = masterRepresentation;
    }

    @Override
    public String toString() {
        return "SurfaceCurve{" + super.toString() +
                " curveId=" + curveId +
                ", associatedGeometry=" + associatedGeometry +
                ", masterRepresentation=" + masterRepresentation +
                '}';
    }
}
