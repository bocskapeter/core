package eu.bopet.jocadv.ie.step.util;

import eu.bopet.jocadv.core.features.basic.curve.JoPreferredSurfaceCurveRepresentation;
import eu.bopet.jocadv.ie.step.StepEntity;
import eu.bopet.jocadv.ie.step.curve.PreferredSurfaceCurveRepresentation;

import java.util.ArrayList;
import java.util.List;

public class UtilIntListOfIntPreferredSurfaceCurveRepresentation extends StepEntity {
    private int curveId;
    private List<Integer> associatedGeometryIds;
    private JoPreferredSurfaceCurveRepresentation masterRep;

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
        masterRep = JoPreferredSurfaceCurveRepresentation.valueOf(masterRepString);
    }

    public int getCurveId() {
        return curveId;
    }

    public List<Integer> getAssociatedGeometryIds() {
        return associatedGeometryIds;
    }

    public JoPreferredSurfaceCurveRepresentation getMasterRep() {
        return masterRep;
    }

    @Override
    public String toString() {
        return super.toString() + ", curveId=" + curveId + ", associatedGeometryIds=" + associatedGeometryIds + ", masterRep=" + masterRep;
    }
}
