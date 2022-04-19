package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringInt;

import java.util.LinkedHashSet;
import java.util.Set;

public class MeasureQualification extends UtilStringInt {
    private Set<Integer> qualifiers;

    public MeasureQualification(int id, String name, String attribute) {
        super(id, name, attribute);
        qualifiers = new LinkedHashSet<>();
        String[] rest = attribute.substring(attribute.indexOf(",(") + 2).split(",");
        for (String s : rest) {
            qualifiers.add(Integer.parseInt(s.replace("#", "").replace(")", "")));
        }
    }

    @Override
    public String toString() {
        return "MeasureQualification{" + super.toString() +
                ", qualifiers=" + qualifiers +
                '}';
    }
}
