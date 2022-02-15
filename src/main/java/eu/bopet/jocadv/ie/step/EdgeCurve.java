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

    public static EdgeCurve getInstance(int id, String name, String attribute) {
        String[] values = attribute.split(",");
        int startId = Integer.parseInt(values[0].substring(1));
        int endId = Integer.parseInt(values[1].substring(1));
        int curveId = Integer.parseInt(values[2].substring(1));
        boolean sameSense = values[3].contains("T");
        EdgeCurve edgeCurve = new EdgeCurve(startId, endId, curveId, sameSense);
        edgeCurve.setId(id);
        edgeCurve.setName(name);
        return edgeCurve;
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
