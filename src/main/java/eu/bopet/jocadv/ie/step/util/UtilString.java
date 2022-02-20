package eu.bopet.jocadv.ie.step.util;

public class UtilString extends StepEntity {
    String string;

    public UtilString(int id, String name, String attribute) {
        super(id, name);
        string = attribute.replace("'", "").stripLeading();
    }

    @Override
    public String toString() {
        return string;
    }
}
