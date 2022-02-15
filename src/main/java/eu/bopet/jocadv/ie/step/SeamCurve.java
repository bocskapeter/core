package eu.bopet.jocadv.ie.step;

import java.util.ArrayList;
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

    public static SeamCurve getInstance(int id, String name, String attribute) {
        String[] values = attribute.split(",");

        int curveId = Integer.parseInt(values[0].substring(1));

        String substring = attribute.substring(attribute.indexOf("(") + 1, attribute.lastIndexOf(")"));
        values = substring.split(",");
        List<Integer> associatedGeometryIds = new ArrayList<>();
        for (String value : values) {
            int associatedGeometryId = Integer.parseInt(value.substring(1));
            associatedGeometryIds.add(associatedGeometryId);
        }
        String masterRepString = attribute.substring(attribute.lastIndexOf(",") + 1)
                .replace(".", "");
        PreferredSurfaceCurveRepresentation masterRep =
                PreferredSurfaceCurveRepresentation.valueOf(masterRepString);
        SeamCurve seamCurve = new SeamCurve(curveId, associatedGeometryIds, masterRep);
        seamCurve.setId(id);
        seamCurve.setName(name);
        return seamCurve;
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
