package eu.bopet.jocadv.ie.step;

public class Vector extends StepEntity {
    private int directionId;
    private double length;

    public Vector(int directionId, double length) {
        this.directionId = directionId;
        this.length = length;
    }

    public static Vector getInstance(int id, String name, String attributes) {
        String[] values = attributes.split(",");
        int directionId = Integer.parseInt(values[0].substring(1));
        double length = Double.parseDouble(values[1]);
        Vector vector = new Vector(directionId, length);
        vector.setId(id);
        vector.setName(name);
        return vector;
    }

    @Override
    public String toString() {
        return "Vector{" + super.toString() +
                " directionId=" + directionId +
                ", length=" + length +
                '}';
    }
}
