package eu.bopet.jocadv.ie.step.util;

public class UtilIntString extends StepEntity {
    private int id;
    private String string;

    public UtilIntString(int id, String name, String attribute) {
        super(id, name);
        String[] values = attribute.split(",");
        this.id = Integer.parseInt(values[0].substring(1));
        string = values[1].replace("'", "");
    }

    @Override
    public String toString() {
        return super.toString() + ", id=" + id + ", '" + string + '\'';
    }
}
