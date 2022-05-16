package eu.bopet.jocadv.ie.step.tolerance;

public class GeometricToleranceInSet implements Tolerance {
    private String name;
    private String description;
    private int magnitude;
    private int toleranceShapeAspect;

    public GeometricToleranceInSet(String attribute) {
        String[] parts = attribute.split(",");
        name = parts[0].replace("'", "");
        description = parts[1].replace("'", "");
        magnitude = Integer.parseInt(parts[2].replace("#", ""));
        toleranceShapeAspect = Integer.parseInt(parts[3].replace("#", ""));
    }

    @Override
    public String toString() {
        return "GeometricTolerance{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", magnitude=" + magnitude +
                ", toleranceShapeAspect=" + toleranceShapeAspect +
                '}';
    }
}
