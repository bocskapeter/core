package eu.bopet.jocadv.ie.step.tolerance;

import eu.bopet.jocadv.ie.step.StepEntityBase;

import java.util.LinkedHashSet;
import java.util.Set;

public class AngularityTolerance extends StepEntityBase {
    private String description;
    private int magnitude;
    private int toleranceShapeAspect;
    private Set<Integer> datumSystem;

    public AngularityTolerance(int id, String name, String attribute) {
        super(id, name);
        String[] parts = attribute.split(",");
        description = parts[0].replace("'", "");
        magnitude = Integer.parseInt(parts[1].replace("#", ""));
        toleranceShapeAspect = Integer.parseInt(parts[2].replace("#", ""));
        datumSystem = new LinkedHashSet<>();
        for (int i = 3; i < parts.length; i++) {
            datumSystem.add(Integer.parseInt(parts[i].replace("#", "")
                    .replace("(", "").replace(")", "")));
        }
    }

    @Override
    public String toString() {
        return "AngularityTolerance{" + super.toString() +
                ", description='" + description + '\'' +
                ", magnitude=" + magnitude +
                ", toleranceShapeAspect=" + toleranceShapeAspect +
                ", datumSystem=" + datumSystem +
                '}';
    }
}
