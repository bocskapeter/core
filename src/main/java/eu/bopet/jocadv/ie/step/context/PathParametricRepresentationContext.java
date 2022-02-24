package eu.bopet.jocadv.ie.step.context;

public class PathParametricRepresentationContext extends Context {
    private int dimension;

    public PathParametricRepresentationContext(String id, String type, int dimension) {
        super(id, type);
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return "PathParametricRepresentationContext{" + super.toString() +
                " dimension=" + dimension +
                '}';
    }
}
