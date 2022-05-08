package eu.bopet.jocadv.ie.step.tolerance;

public class UnequallyDisposedGeometricTolerance implements Tolerance {
    private int displacement;

    public UnequallyDisposedGeometricTolerance(String attribute) {
        displacement = Integer.parseInt(attribute.replace("#", ""));
    }

    @Override
    public String toString() {
        return "UnequallyDisposedGeometricTolerance{" +
                "displacement=" + displacement +
                '}';
    }
}
