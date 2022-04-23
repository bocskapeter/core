package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringIntBoolean;

import java.util.ArrayList;
import java.util.List;

public class DatumSystem extends UtilStringIntBoolean {
    private List<Integer> constituents;

    public DatumSystem(int id, String name, String attribute) {
        super(id, name, attribute);
        String rest = attribute.substring(attribute.lastIndexOf(".,") + 2)
                .replace("(", "").replace(")", "");
        String[] parts = rest.split(",");
        constituents = new ArrayList<>();
        for (String s : parts) {
            constituents.add(Integer.parseInt(s.replace("#", "")));
        }
    }

    @Override
    public String toString() {
        return "DatumSystem{" + super.toString() +
                ", constituents=" + constituents +
                '}';
    }
}
