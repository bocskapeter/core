package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.StepEntityBase;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class MechanicalDesignGeometricPresentationRepresentation extends StepEntityBase {
    private Set<Integer> items;
    private int context;

    public MechanicalDesignGeometricPresentationRepresentation(int id, String name, String attributes) {
        super(id, name);
        items = new LinkedHashSet<>();
        String[] parts = attributes.split(Pattern.quote("),"));
        String[] itemStrings = parts[0].replace("(", "").split(",");
        for (String s : itemStrings) {
            items.add(Integer.parseInt(s.replace("#", "")));
        }
        context = Integer.parseInt(parts[1].replace("#", ""));
    }

    @Override
    public String toString() {
        return "MechanicalDesignGeometricPresentationRepresentation{" + super.toString() +
                " items=" + items +
                ", context=" + context +
                '}';
    }
}
