package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringIntInt;

import java.util.LinkedHashSet;
import java.util.Set;

public class PerpendicularityTolerance extends UtilStringIntInt {
    private Set<Integer> datumSystem;

    public PerpendicularityTolerance(int id, String name, String attribute) {
        super(id, name, attribute);
        datumSystem = new LinkedHashSet<>();
        String[] parts = attribute.substring(attribute.indexOf("(") + 1).split(",");
        for (String s : parts) {
            datumSystem.add(Integer.parseInt(s.replace("#", "").replace(")", "")));
        }
    }

    @Override
    public String toString() {
        return "PerpendicularityTolerance{" + super.toString() +
                ", datumSystem=" + datumSystem +
                '}';
    }
}
