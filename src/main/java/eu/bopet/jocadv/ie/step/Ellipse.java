package eu.bopet.jocadv.ie.step;

public class Ellipse extends StepEntity {
    private int positionId;
    private double axis1;
    private double axis2;

    public Ellipse(int positionId, double axis1, double axis2) {
        this.positionId = positionId;
        this.axis1 = axis1;
        this.axis2 = axis2;
    }

    public static Ellipse getInstance(int id, String name, String attribute) {
        String[] values = attribute.split(",");
        int positionId = Integer.parseInt(values[0].substring(1));
        double axis1 = Double.parseDouble(values[1]);
        double axis2 = Double.parseDouble(values[2]);
        Ellipse ellipse = new Ellipse(positionId, axis1, axis2);
        ellipse.setId(id);
        ellipse.setName(name);
        return ellipse;
    }

    @Override
    public String toString() {
        return "Ellipse{" + super.toString() +
                " positionId=" + positionId +
                ", axis1=" + axis1 +
                ", axis2=" + axis2 +
                '}';
    }
}
