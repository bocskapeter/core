package eu.bopet.jocadv.ie.step;

public class ConicalSurface extends StepEntity {
    private int positionId;
    private double radius;
    private double angle;

    public ConicalSurface(int positionId, double radius, double angle) {
        this.positionId = positionId;
        this.radius = radius;
        this.angle = angle;
    }

    public static ConicalSurface getInstance(int id, String name, String attribute) {
        String[] values = attribute.split(",");
        int positionId = Integer.parseInt(values[0].substring(1));
        double radius = Double.parseDouble(values[1]);
        double angle = Double.parseDouble(values[2]);
        ConicalSurface conicalSurface = new ConicalSurface(positionId, radius, angle);
        conicalSurface.setId(id);
        conicalSurface.setName(name);
        return conicalSurface;
    }

    @Override
    public String toString() {
        return "ConicalSurface{" + super.toString() +
                " positionId=" + positionId +
                ", radius=" + radius +
                ", angle=" + angle +
                '}';
    }
}
