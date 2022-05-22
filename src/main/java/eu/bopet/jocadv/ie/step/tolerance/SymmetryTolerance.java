package eu.bopet.jocadv.ie.step.tolerance;

public class SymmetryTolerance extends GeometricToleranceWithDatumReference {
    public SymmetryTolerance(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "SymmetryTolerance{" + super.toString() + "}";
    }
}
