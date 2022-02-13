package eu.bopet.jocadv.ie.step;

public class Line extends StepEntity {
    private int cartesianPointId;
    private int vectorId;

    public Line(int cartesianPointId, int vectorId) {
        this.cartesianPointId = cartesianPointId;
        this.vectorId = vectorId;
    }

    public static Line getInstance(int id, String name, String attributes) {
        String[] values = attributes.split(",");
        int cartesianPointId = Integer.parseInt(values[0].substring(1));
        int vectorId = Integer.parseInt(values[1].substring(1));
        Line line = new Line(cartesianPointId, vectorId);
        line.setId(id);
        line.setName(name);
        return line;
    }

    @Override
    public String toString() {
        return "Line{" + super.toString() +
                " cartesianPointId=" + cartesianPointId +
                ", vectorId=" + vectorId +
                '}';
    }
}
