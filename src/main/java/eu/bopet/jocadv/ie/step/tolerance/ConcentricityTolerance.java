package eu.bopet.jocadv.ie.step.tolerance;

public class ConcentricityTolerance extends GeometricToleranceWithDatumReference {
    public ConcentricityTolerance(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "ConcentricityTolerance{" + super.toString() + "}";
    }
}
