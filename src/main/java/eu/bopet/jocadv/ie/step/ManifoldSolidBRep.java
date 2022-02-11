package eu.bopet.jocadv.ie.step;

public class ManifoldSolidBRep extends StepEntity {
    private int shellId;

    public ManifoldSolidBRep(int shellId) {
        this.shellId = shellId;
    }

    @Override
    public String toString() {
        return "ManifoldSolidBRep{" + super.toString() +
                " shellId=" + shellId +
                '}';
    }
}
