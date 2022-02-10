package eu.bopet.jocadv.ie.step;

public class VertexPoint extends StepEntity {
    private int pointId;

    public VertexPoint(int pointId) {
        this.pointId = pointId;
    }

    @Override
    public String toString() {
        return "VertexPoint{" + super.toString() +
                " pointId=" + pointId +
                '}';
    }
}
