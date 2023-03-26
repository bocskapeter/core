package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntityBase;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ComplexTriangulatedSurfaceSet extends StepEntityBase {
    private final int coordinatesId;
    private final int pnMax;
    private final List<List<Double>> normals;
    private final List<Integer> pnIndex;
    private final List<List<Integer>> strips;
    private final List<List<Integer>> fans;

    public ComplexTriangulatedSurfaceSet(int id, String name, String attribute) {
        super(id, name);
        coordinatesId =
                Integer.parseInt(attribute.substring(0, attribute.indexOf(",")).replace("#", ""));
        pnMax = Integer.parseInt(attribute.substring(attribute.indexOf(",") + 1, attribute.indexOf(",(")));
        normals = new ArrayList<>();
        String rest = attribute.substring(attribute.indexOf(",(") + 1);
        List<String> sets = StepEntityBase.getSets(rest);
        String[] coordinatesString = sets.get(0).substring(sets.get(0).indexOf("(") + 1,
                sets.get(0).lastIndexOf(")")).split(Pattern.quote("),("));
        for (String c : coordinatesString) {
            List<Double> coordinates = new ArrayList<>();
            c = c.replace("(", "").replace(")", "");
            String[] cString = c.split(",");
            for (String s : cString) {
                if (!s.isEmpty()) coordinates.add(Double.parseDouble(s));
            }
            if (!coordinates.isEmpty()) normals.add(coordinates);
        }
        pnIndex = new ArrayList<>();
        String[] pnIs = attribute.substring(attribute.indexOf(")),(") + 4, attribute.indexOf("),((")).split(",");
        for (String s : pnIs) {
            s = s.replace(")", "").replace("(", "");
            if (!s.equals("")) pnIndex.add(Integer.parseInt(s));
        }
        rest = attribute.substring(attribute.indexOf("),((") + 4);
        String[] stripsStrings = rest.split(Pattern.quote("),("));
        strips = new ArrayList<>();
        for (String s : stripsStrings) {
            List<Integer> integerList = new ArrayList<>();
            String[] strings = s.replace(")", "").replace("(", "").split(",");
            for (String s1 : strings) {
                if (!s1.isEmpty()) integerList.add(Integer.parseInt(s1));
            }
            if (!integerList.isEmpty()) strips.add(integerList);
        }
        fans = new ArrayList<>();
        String[] fansStrings = rest.substring(rest.indexOf(")),(") + 4).split(Pattern.quote("),("));
        for (String s : fansStrings) {
            List<Integer> integerList = new ArrayList<>();
            String[] strings = s.replace(")", "").replace("(", "").split(",");
            for (String s1 : strings) {
                if (!s1.equals("")) integerList.add(Integer.parseInt(s1));
            }
            if (!integerList.isEmpty()) fans.add(integerList);
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
