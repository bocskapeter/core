package eu.bopet.jocadv.ie.step;

public class EdgeCurve extends StepEntity {
    private int startId;
    private int endId;
    private int curveId;
    private boolean sameSense;

    public EdgeCurve(int startId, int endId, int curveId, boolean sameSense) {
        this.startId = startId;
        this.endId = endId;
        this.curveId = curveId;
        this.sameSense = sameSense;
    }

    @Override
    public String toString() {
        return "EdgeCurve{" + super.toString() +
                " startId=" + startId +
                ", endId=" + endId +
                ", curveId=" + curveId +
                ", sameSense=" + sameSense +
                '}';
    }
}
