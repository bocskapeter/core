package eu.bopet.jocadv.ie.step.util;

public class UtilStringString extends StepEntityBase {
    private String s1;
    private String s2;

    public UtilStringString(int id, String name, String attribute) {
        super(id, name);
        String[] parts = attribute.replace("'", "").split(",");
        s1 = parts[0];
        s2 = parts[1];
    }

    @Override
    public String toString() {
        return super.toString() + ", 1='" + s1 + '\'' + ", 2='" + s2 + '\'';
    }
}
