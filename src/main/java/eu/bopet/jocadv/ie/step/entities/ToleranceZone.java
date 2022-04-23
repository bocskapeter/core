package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringInt;

import java.util.LinkedHashSet;
import java.util.Set;

public class ToleranceZone extends UtilStringInt {
    private final String description;
    private final boolean productDefinitional;
    private final Set<Integer> tolerances;
    private final int form;

    public ToleranceZone(int id, String name, String attribute) {
        super(id, name, attribute);
        description = attribute.substring(0, attribute.indexOf("',"));
        productDefinitional = attribute.substring(attribute.indexOf(",."), attribute.indexOf(",.") + 4).contains("T");
        String[] parts = attribute.substring(attribute.indexOf(",(") + 2, attribute.indexOf("),")).split(",");
        tolerances = new LinkedHashSet<>();
        for (String s : parts) {
            tolerances.add(Integer.parseInt(s.replace("#", "")));
        }
        form = Integer.parseInt(attribute.substring(attribute.lastIndexOf("#") + 1));
    }

    @Override
    public String toString() {
        return "ToleranceZone{" + super.toString() +
                ", description='" + description + '\'' +
                ", productDefinitional=" + productDefinitional +
                ", tolerances=" + tolerances +
                ", form=" + form +
                '}';
    }
}
