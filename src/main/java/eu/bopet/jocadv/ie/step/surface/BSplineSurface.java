package eu.bopet.jocadv.ie.step.surface;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BSplineSurface implements Surface {
    private int uDegree;
    private int vDegree;
    private List<List<Integer>> controlPoints;
    private BSplineSurfaceForm surfaceForm;
    private boolean uClosed;
    private boolean vClosed;
    private boolean selfIntersect;

    public BSplineSurface(String attribute) {
        String[] uvParts = attribute.replace(" ", "").split(",");
        uDegree = Integer.parseInt(uvParts[0]);
        vDegree = Integer.parseInt(uvParts[1]);
        controlPoints = new ArrayList<>();
        String cPointString = attribute.substring(attribute.indexOf("((") + 2, attribute.indexOf("))"));
        String[] cPointStrings = cPointString.split(Pattern.quote("),("));
        for (String s : cPointStrings) {
            String[] cPointPartStrings = s.split(",");
            List<Integer> cPointPartList = new ArrayList<>();
            for (String cPart : cPointPartStrings) {
                cPointPartList.add(Integer.parseInt(cPart.replace("#", "")));
            }
            controlPoints.add(cPointPartList);
        }
        String secondPart = attribute.substring(attribute.indexOf("))") + 3);
        String[] secondParts = secondPart.split(",");
        surfaceForm = BSplineSurfaceForm.valueOf(secondParts[0].replace(".", ""));
        uClosed = secondParts[1].contains("T");
        vClosed = secondParts[2].contains("T");
        selfIntersect = secondParts[3].contains("T");
    }

    @Override
    public String toString() {
        return "BSplineSurface{" +
                "uDegree=" + uDegree +
                ", vDegree=" + vDegree +
                ", controlPoints=" + controlPoints +
                ", surfaceForm=" + surfaceForm +
                ", uClosed=" + uClosed +
                ", vClosed=" + vClosed +
                ", selfIntersect=" + selfIntersect +
                '}';
    }
}
