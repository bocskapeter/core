package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntityBase;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ComplexTriangulatedSurfaceSet extends StepEntityBase {
    private int coordinatesId;
    private int pnMax;
    private List<List<Double>> normals;
    private List<Integer> pnIndex;
    private List<List<Integer>> strips;
    private List<List<Integer>> fans;

    public ComplexTriangulatedSurfaceSet(int id, String name, String attribute) {
        super(id, name);
        coordinatesId =
                Integer.parseInt(attribute.substring(0, attribute.indexOf(",")).replace("#", ""));
        pnMax = Integer.parseInt(attribute.substring(attribute.indexOf(",") + 1, attribute.indexOf(",(")));
        normals = new ArrayList<>();
        String[] coordinatesString = attribute.substring(attribute.indexOf(",((") + 3, attribute.indexOf(")),"))
                .split(Pattern.quote("),("));
        for (String c : coordinatesString) {
            List<Double> coordinates = new ArrayList<>();
            String[] cString = c.split(",");
            for (String s : cString) {
                coordinates.add(Double.parseDouble(s));
            }
            normals.add(coordinates);
        }
        pnIndex = new ArrayList<>();
        String[] pnIs = attribute.substring(attribute.indexOf(")),(") + 4, attribute.indexOf("),((")).split(",");
        for (String s : pnIs) {
            s = s.replace(")", "").replace("(", "");
            if (!s.equals("")) pnIndex.add(Integer.parseInt(s));
        }
        String rest = attribute.substring(attribute.indexOf("),((") + 4);
        String[] stripsStrings = rest.split(Pattern.quote("),("));
        strips = new ArrayList<>();
        for (String s : stripsStrings) {
            List<Integer> integerList = new ArrayList<>();
            String[] strings = s.replace(")", "").replace("(", "").split(",");
            for (String s1 : strings) {
                if (!s1.isEmpty()) integerList.add(Integer.parseInt(s1));
            }
            strips.add(integerList);
        }
        fans = new ArrayList<>();
        String[] fansStrings = rest.substring(rest.indexOf(")),(") + 4).split(Pattern.quote("),("));
        for (String s : fansStrings) {
            List<Integer> integerList = new ArrayList<>();
            String[] strings = s.replace(")", "").replace("(", "").split(",");
            for (String s1 : strings) {
                if (!s1.equals("")) integerList.add(Integer.parseInt(s1));
            }
            fans.add(integerList);
        }
    }

    @Override
    public String toString() {
        return "ComplexTriangulatedSurfaceSet{" + super.toString() +
                ", coordinatesId=" + coordinatesId +
                ", pnMax=" + pnMax +
                ", normals=" + normals +
                ", pnIndex=" + pnIndex +
                ", strips=" + strips +
                ", fans=" + fans +
                '}';
    }
}
