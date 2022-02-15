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

    public static OrientedEdge getInstance(int id, String name, String attribute) {
        String[] values = attribute.split(",");
        int startId;
        if (values[0].contains("*")) startId = -1;
        else startId = Integer.parseInt(values[0].substring(1));
        int endId;
        if (values[1].contains("*")) endId = -1;
        else endId = Integer.parseInt(values[1].substring(1));
        int edgeId = Integer.parseInt(values[2].substring(1));
        boolean orientation = values[3].contains("T");
        OrientedEdge orientedEdge = new OrientedEdge(startId, endId, edgeId, orientation);
        orientedEdge.setId(id);
        orientedEdge.setName(name);
        return orientedEdge;
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
