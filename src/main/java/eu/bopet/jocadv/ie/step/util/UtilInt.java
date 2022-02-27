package eu.bopet.jocadv.ie.step.util;

public class UtilInt extends StepEntityBase {
    private int id;

    public UtilInt(int id, String name, String attribute) {
        super(id, name);
        this.id = Integer.parseInt(attribute.substring(1));
    }

    @Override
    public String toString() {
        return super.toString() + ", id=" + id;
    }
}
