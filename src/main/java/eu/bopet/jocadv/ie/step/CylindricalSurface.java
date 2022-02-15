package eu.bopet.jocadv.ie.step;

public class CylindricalSurface extends StepEntity {
    private int positionId;
    private double radius;

    public CylindricalSurface(int positionId, double radius) {
        this.positionId = positionId;
        this.radius = radius;
    }

    public static CylindricalSurface getInstance(int id, String name, String attribute) {
        String[] values = attribute.split(",");
        int positionId = Integer.parseInt(values[0].substring(1));
        double radius = Double.parseDouble(values[1]);
        CylindricalSurface cylindricalSurface = new CylindricalSurface(positionId, radius);
        cylindricalSurface.setId(id);
        cylindricalSurface.setName(name);
        return cylindricalSurface;
    }

    @Override
    public String toString() {
        return "CylindricalSurface{" + super.toString() +
                " positionId=" + positionId +
                ", radius=" + radius +
                '}';
    }
}
