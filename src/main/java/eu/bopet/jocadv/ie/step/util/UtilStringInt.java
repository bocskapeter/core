package eu.bopet.jocadv.ie.step.util;

public class UtilStringInt extends StepEntity {
    private String string;
    private int id;

    public UtilStringInt(int id, String name, String attribute) {
        super(id, name);
        String[] values = attribute.split(",");
        string = values[0].replace("'", "");
        this.id = Integer.parseInt(values[1].substring(1));
    }

    @Override
    public String toString() {
        return "'" + string + '\'' + ", " + id + '}';
    }
}
