package eu.bopet.jocadv.ie.step;

public class FaceBound extends StepEntity {
    private int loopId;
    private boolean orientation;

    public FaceBound(int loopId, boolean orientation) {
        this.loopId = loopId;
        this.orientation = orientation;
    }

    public static FaceBound getInstance(int id, String name, String attribute) {
        String[] values = attribute.split(",");
        int loopId = Integer.parseInt(values[0].substring(1));
        boolean orientation = values[1].contains("T");
        FaceBound faceBound = new FaceBound(loopId, orientation);
        faceBound.setId(id);
        faceBound.setName(name);
        return faceBound;
    }

    @Override
    public String toString() {
        return "FaceBound{" + super.toString() +
                " loopId=" + loopId +
                ", orientation=" + orientation +
                '}';
    }
}
