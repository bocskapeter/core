package eu.bopet.jocadv.ie.step;

public class Line extends StepEntity {
    private int cartesianPointId;
    private int vectorId;

    public Line(int cartesianPointId, int vectorId) {
        this.cartesianPointId = cartesianPointId;
        this.vectorId = vectorId;
    }

    @Override
    public String toString() {
        return "Line{" + super.toString() +
                " cartesianPointId=" + cartesianPointId +
                ", vectorId=" + vectorId +
                '}';
    }
}
