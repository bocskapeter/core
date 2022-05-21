package eu.bopet.jocadv.ie.step.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ComplexTriangulatedFace extends TessellatedFace {
    private List<Integer> pnindex;
    private List<List<Integer>> triangleStrips;
    private List<List<Integer>> triangleFans;

    public ComplexTriangulatedFace(int id, String name, String attribute) {
        super(id, name, attribute);
        String rest = attribute.substring(attribute.indexOf(")),") + 3);
        rest = rest.substring(rest.indexOf(",") + 1);
        String pnindexStrings = rest.substring(rest.indexOf("(") + 1, rest.indexOf(")"));
        String[] pnindexString = pnindexStrings.split(",");
        pnindex = new ArrayList<>();
        for (String s : pnindexString) {
            pnindex.add(Integer.parseInt(s));
        }
        rest = rest.substring(rest.indexOf("),") + 2);
        String triangleStripsStrings = rest.substring(rest.indexOf("((") + 2, rest.indexOf(")),"));
        String[] parts = triangleStripsStrings.split(Pattern.quote("),("));
        triangleStrips = new ArrayList<>();
        for (String s : parts) {
            List<Integer> strip = new ArrayList<>();
            String[] sParts = s.split(",");
            for (String sPart : sParts) {
                strip.add(Integer.parseInt(sPart));
            }
            triangleStrips.add(strip);
        }
        rest = rest.substring(rest.indexOf(")),") + 3);
        triangleFans = new ArrayList<>();
        rest = rest.replace("(", "").replace(")", "");
        if (!rest.isEmpty()) {
            System.out.println(" Not processed ComplexTriangulatedFace: " + this);
        }
    }

    @Override
    public String toString() {
        return "ComplexTriangulatedFace{" + super.toString() +
                ", pnindex=" + pnindex +
                ", triangleStrips=" + triangleStrips +
                ", triangleFans=" + triangleFans +
                '}';
    }
}
