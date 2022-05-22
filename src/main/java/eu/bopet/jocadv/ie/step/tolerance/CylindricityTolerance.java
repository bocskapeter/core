package eu.bopet.jocadv.ie.step.tolerance;

public class CylindricityTolerance extends GeometricTolerance {
    public CylindricityTolerance(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "CylindricityTolerance{" + super.toString() + "}";
    }
}
