package eu.bopet.jocadv.ie.step;

public class VertexPoint extends StepEntity {
    private int pointId;

    public VertexPoint(int pointId) {
        this.pointId = pointId;
    }

    public static VertexPoint getInstance(int id, String name, String attributes) {
        int pointId = Integer.parseInt(attributes.substring(1));
        VertexPoint vertexPoint = new VertexPoint(pointId);
        vertexPoint.setId(id);
        vertexPoint.setName(name);
        return vertexPoint;
    }

    @Override
    public String toString() {
        return "VertexPoint{" + super.toString() +
                " pointId=" + pointId +
                '}';
    }
}
