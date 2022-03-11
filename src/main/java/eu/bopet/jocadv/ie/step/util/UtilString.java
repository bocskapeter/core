package eu.bopet.jocadv.ie.step.util;

public class UtilString extends StepEntityBase {
    String string;

    public UtilString(int id, String name, String attribute) {
        super(id, name);
        string = attribute.replace("'", "").stripLeading();
    }

    @Override
    public String toString() {
        return super.toString() + ", " + string;
    }
}
