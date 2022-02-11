package eu.bopet.jocadv.ie.step;

public class FaceBound extends StepEntity {
    private int loopId;
    private boolean orientation;

    public FaceBound(int loopId, boolean orientation) {
        this.loopId = loopId;
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return "FaceBound{" + super.toString() +
                " loopId=" + loopId +
                ", orientation=" + orientation +
                '}';
    }
}
