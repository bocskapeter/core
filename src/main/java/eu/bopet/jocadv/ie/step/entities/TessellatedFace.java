package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntity;

import java.util.Arrays;
import java.util.regex.Pattern;

public class TessellatedFace extends StepEntity {
    private int coordinates;
    private int pnmax;
    private double[][] normals;
    private int geometricLink;

    public TessellatedFace(int id, String name, String attribute) {
        super(id, name);
        String coordinateString = attribute.substring(0, attribute.indexOf(",")).replace("#", "");
        coordinates = Integer.parseInt(coordinateString);
        String pnmaxString = attribute.substring(attribute.indexOf(",") + 1, attribute.indexOf(",("));
        pnmax = Integer.parseInt(pnmaxString);
        String normalStrings = attribute.substring(attribute.indexOf("((") + 2, attribute.indexOf("))"));
        String[] normalString = normalStrings.split(Pattern.quote("),("));
        normals = new double[normalString.length][3];
        for (int i = 0; i < normalString.length; i++) {
            String[] s = normalString[i].split(",");
            for (int j = 0; j < s.length; j++) {
                normals[i][j] = Double.parseDouble(s[j]);
            }
        }
        String rest = attribute.substring(attribute.indexOf(")),") + 3);
        String geometricLinkString = rest.substring(0, rest.indexOf(",")).replace("#", "");
        geometricLink = Integer.parseInt(geometricLinkString);
    }

    @Override
    public String toString() {
        return "TessellatedFace{" + super.toString() +
                ", coordinates=" + coordinates +
                ", pnmax=" + pnmax +
                ", normals=" + Arrays.deepToString(normals) +
                ", geometricLink=" + geometricLink +
                '}';
    }
}
