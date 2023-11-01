package eu.bopet.jocadv.ie.step.util;

import eu.bopet.jocadv.ie.step.StepEntity;

public class UtilStringInt extends StepEntity {
    private String string;
    private int id;

    public UtilStringInt(int id, String name, String attribute) {
        super(id, name);
        if (!attribute.isEmpty()) {
            String[] values = attribute.split(",");
            string = values[0].replace("'", "");
            this.id = Integer.parseInt(values[1].substring(1));
        } else {
            string = "";
            this.id = -1;
        }

    }

    @Override
    public String toString() {
        return super.toString() + ", '" + string + '\'' + ", id=" + id;
    }
}
