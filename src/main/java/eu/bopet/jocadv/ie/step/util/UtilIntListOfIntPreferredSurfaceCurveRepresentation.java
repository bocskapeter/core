package eu.bopet.jocadv.ie.step.util;

import eu.bopet.jocadv.ie.step.PreferredSurfaceCurveRepresentation;

import java.util.ArrayList;
import java.util.List;

public class UtilIntListOfIntPreferredSurfaceCurveRepresentation extends StepEntity {
    private int curveId;
    private List<Integer> associatedGeometryIds;
    private PreferredSurfaceCurveRepresentation masterRep;

    public UtilIntListOfIntPreferredSurfaceCurveRepresentation(int id, String name, String attribute) {
        super(id, name);
        String[] values = attribute.split(",");

        curveId = Integer.parseInt(values[0].substring(1));

        String substring = attribute.substring(attribute.indexOf("(") + 1, attribute.lastIndexOf(")"));
        values = substring.split(",");
        associatedGeometryIds = new ArrayList<>();
        for (String value : values) {
            int associatedGeometryId = Integer.parseInt(value.substring(1));
            associatedGeometryIds.add(associatedGeometryId);
        }
        String masterRepString = attribute.substring(attribute.lastIndexOf(",") + 1)
                .replace(".", "");
        masterRep = PreferredSurfaceCurveRepresentation.valueOf(masterRepString);
    }

    @Override
    public String toString() {
        return "curveId=" + curveId + ", associatedGeometryIds=" + associatedGeometryIds + ", masterRep=" + masterRep;
    }
}
