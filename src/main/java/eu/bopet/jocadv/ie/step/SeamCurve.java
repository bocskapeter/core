package eu.bopet.jocadv.ie.step;

import java.util.List;

public class SeamCurve extends StepEntity {
    private int curveId;
    private List<Integer> associatedGeometryIds;
    private PreferredSurfaceCurveRepresentation masterRep;

    public SeamCurve(int curveId, List<Integer> associatedGeometryIds, PreferredSurfaceCurveRepresentation masterRep) {
        this.curveId = curveId;
        this.associatedGeometryIds = associatedGeometryIds;
        this.masterRep = masterRep;
    }

    @Override
    public String toString() {
        return "SeamCurve{" + super.toString() +
                " curveId=" + curveId +
                ", associatedGeometryIds=" + associatedGeometryIds +
                ", masterRep=" + masterRep +
                '}';
    }
}
