package eu.bopet.jocadv.ie.step;

public class ToroidalSurface extends StepEntity {
    private int positionId;
    private double majorRadius;
    private double minorRadius;

    public ToroidalSurface(int positionId, double majorRadius, double minorRadius) {
        this.positionId = positionId;
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    public static ToroidalSurface getInstance(int id, String name, String attribute) {
        String[] values = attribute.split(",");
        int positionId = Integer.parseInt(values[0].substring(1));
        double majorRadius = Double.parseDouble(values[1]);
        double minorRadius = Double.parseDouble(values[2]);
        ToroidalSurface toroidalSurface = new ToroidalSurface(positionId, majorRadius, minorRadius);
        toroidalSurface.setId(id);
        toroidalSurface.setName(name);
        return toroidalSurface;
    }

    @Override
    public String toString() {
        return "ToroidalSurface{" + super.toString() +
                " positionId=" + positionId +
                ", majorRadius=" + majorRadius +
                ", minorRadius=" + minorRadius +
                '}';
    }
}
