package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringIntInt;

import java.util.LinkedHashSet;
import java.util.Set;

public class CircularRunOutTolerance extends UtilStringIntInt {
    private Set<Integer> datumSystem;

    public CircularRunOutTolerance(int id, String name, String attribute) {
        super(id, name, attribute);
        datumSystem = new LinkedHashSet<>();
        String rest = attribute.substring(attribute.lastIndexOf(",(") + 1);
        String[] parts = rest.replace("(", "").replace(")", "").split(",");
        for (String s : parts) {
            datumSystem.add(Integer.parseInt(s.replace("#", "")));
        }
    }

    @Override
    public String toString() {
        return "CircularRunOutTolerance{" + super.toString() +
                ", datumSystem=" + datumSystem +
                '}';
    }
}
