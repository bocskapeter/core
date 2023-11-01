package eu.bopet.jocadv.ie.step.tolerance;

import eu.bopet.jocadv.ie.step.StepEntity;

public class GeometricTolerance extends StepEntity {
    private String description;
    private int magnitude;
    private int toleranceShapeAspect;

    public GeometricTolerance(int id, String name, String attribute) {
        super(id, name);
        String[] parts = attribute.split(",");
        description = parts[0].replace("'", "");
        magnitude = Integer.parseInt(parts[1].replace("#", ""));
        toleranceShapeAspect = Integer.parseInt(parts[2].replace("#", ""));
    }

    @Override
    public String toString() {
        return "GeometricTolerance{" + super.toString() +
                ", description='" + description + '\'' +
                ", magnitude=" + magnitude +
                ", toleranceShapeAspect=" + toleranceShapeAspect +
                '}';
    }
}
