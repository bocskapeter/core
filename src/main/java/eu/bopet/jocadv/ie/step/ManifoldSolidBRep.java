package eu.bopet.jocadv.ie.step;

public class ManifoldSolidBRep extends StepEntity {
    private int shellId;

    public ManifoldSolidBRep(int shellId) {
        this.shellId = shellId;
    }

    public static ManifoldSolidBRep getInstance(int id, String name, String attribute) {
        int shellId = Integer.parseInt(attribute.substring(1));
        ManifoldSolidBRep manifoldSolidBRep = new ManifoldSolidBRep(shellId);
        manifoldSolidBRep.setId(id);
        manifoldSolidBRep.setName(name);
        return manifoldSolidBRep;
    }

    @Override
    public String toString() {
        return "ManifoldSolidBRep{" + super.toString() +
                " shellId=" + shellId +
                '}';
    }
}
