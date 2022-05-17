package eu.bopet.jocadv.ie.step.tolerance;

public class TotalRunOutTolerance extends GeometricToleranceWithDatumReference {
    public TotalRunOutTolerance(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "TotalRunOutTolerance{" + super.toString() + "}";
    }
}
