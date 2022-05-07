package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntityBase;

import java.util.LinkedHashSet;
import java.util.Set;

public class SurfaceStyleRenderingWithProperties extends StepEntityBase {
    private ShadingSurfaceMethod renderingMethod;
    private int colour;
    private Set<Integer> properties;

    public SurfaceStyleRenderingWithProperties(int id, String name, String attributes) {
        super(id, name);
        String[] parts = attributes.split(",");
        renderingMethod = ShadingSurfaceMethod.valueOf(parts[0].replace(".", ""));
        colour = Integer.parseInt(parts[1].replace("#", ""));
        properties = new LinkedHashSet<>();
        String[] rest = attributes.substring(attributes.indexOf("(") + 1).split(",");
        for (String s : rest) {
            properties.add(Integer.parseInt(s.replace("#", "").replace(")", "")));
        }
    }

    @Override
    public String toString() {
        return "SurfaceStyleRenderingWithProperties{" + super.toString() +
                ", renderingMethod=" + renderingMethod +
                ", colour=" + colour +
                ", properties=" + properties +
                '}';
    }
}
