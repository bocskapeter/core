package eu.bopet.jocadv.ie.step;

public class OrientedEdge extends StepEntity {
    private int startId;
    private int endId;
    private int edgeId;
    private boolean orientation;

    public OrientedEdge(int startId, int endId, int edgeId, boolean orientation) {
        this.startId = startId;
        this.endId = endId;
        this.edgeId = edgeId;
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return "OrientedEdge{" + super.toString() +
                " startId=" + startId +
                ", endId=" + endId +
                ", edgeId=" + edgeId +
                ", orientation=" + orientation +
                '}';
    }
}
