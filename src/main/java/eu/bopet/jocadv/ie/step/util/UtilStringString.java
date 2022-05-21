package eu.bopet.jocadv.ie.step.util;

import eu.bopet.jocadv.ie.step.StepEntityBase;

public class UtilStringString extends StepEntityBase {
    private String s1;
    private String s2;

    public UtilStringString(int id, String name, String attribute) {
        super(id, name);
        String[] parts = attribute.split(",");
        s1 = parts[0].replace("'", "");
        s2 = parts[1].replace("'", "");
    }

    @Override
    public String toString() {
        return super.toString() + ", 1='" + s1 + '\'' + ", 2='" + s2 + '\'';
    }
}
