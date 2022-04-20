package eu.bopet.jocadv.ie.step.util;

public class UtilStringIntIntInt extends StepEntityBase {
    private final String string;
    private final int id1;
    private final int id2;
    private final int id3;

    public UtilStringIntIntInt(int id, String name, String attribute) {
        super(id, name);
        String[] values = attribute.split(",");
        this.string = values[0].replace("'", "").stripLeading();
        this.id1 = Integer.parseInt(values[1].replace("#", ""));
        this.id2 = Integer.parseInt(values[2].replace("#", ""));
        this.id3 = Integer.parseInt(values[3].replace("#", ""));
    }

    @Override
    public String toString() {
        return super.toString() + ", '" + string + "', id1=" + id1 + ", id2=" + id2 + ", id3=" + id3;
    }
}