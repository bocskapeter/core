package eu.bopet.jocadv.ie.step;

import java.util.ArrayList;
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

    public static SurfaceCurve getInstance(int id, String name, String attribute) {
        String[] values = attribute.split(",");
        int curveId = Integer.parseInt(values[0].substring(1));
        String substring = attribute.substring(attribute.indexOf("(") + 1, attribute.lastIndexOf(")"));
        String[] geometries = substring.split(",");
        List<Integer> associatedGeometry = new ArrayList<>();
        for (String geometry : geometries) {
            associatedGeometry.add(Integer.parseInt(geometry.substring(1)));
        }
        String last = values[values.length - 1].replace(".", "");
        PreferredSurfaceCurveRepresentation rep = PreferredSurfaceCurveRepresentation.valueOf(last);
        SurfaceCurve surfaceCurve = new SurfaceCurve(curveId, associatedGeometry, rep);
        surfaceCurve.setId(id);
        surfaceCurve.setName(name);
        return surfaceCurve;
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
