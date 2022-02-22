package eu.bopet.jocadv.ie.step.context;

public class GeometricRepresentationContext extends Context {
    private int dimension;

    public GeometricRepresentationContext(String id, String type, int dimension) {
        super(id, type);
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return "GeometricRepresentationContext{" + super.toString() +
                " dimension=" + dimension +
                '}';
    }
}
