package eu.bopet.jocadv.ie.step.tolerance;

public class RoundnessTolerance extends GeometricTolerance {
    public RoundnessTolerance(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "RoundnessTolerance{" + super.toString() + "}";
    }
}
