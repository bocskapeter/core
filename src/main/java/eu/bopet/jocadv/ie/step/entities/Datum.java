package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringIntBoolean;

public class Datum extends UtilStringIntBoolean {
    private String identification;

    public Datum(int id, String name, String attribute) {
        super(id, name, attribute);
        identification = attribute.substring(attribute.lastIndexOf(".,'") + 3).replace("'", "");
    }

    @Override
    public String toString() {
        return "Datum{" + super.toString() +
                ", identification='" + identification + '\'' +
                '}';
    }
}
