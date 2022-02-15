package eu.bopet.jocadv.ie.step;

public class Circle extends StepEntity {
    private int positionId;
    private double radius;

    public Circle(int positionId, double radius) {
        this.positionId = positionId;
        this.radius = radius;
    }

    public static Circle getInstance(int id, String name, String attribute) {
        String[] values = attribute.split(",");
        int positionId = Integer.parseInt(values[0].substring(1));
        double radius = Double.parseDouble(values[1]);
        Circle circle = new Circle(positionId, radius);
        circle.setId(id);
        circle.setName(name);
        return circle;
    }

    @Override
    public String toString() {
        return "Circle{" + super.toString() +
                " positionId=" + positionId +
                ", radius=" + radius +
                '}';
    }
}
