package eu.bopet.jocadv.ie.step.util;

public class UtilStringIntBoolean extends StepEntityBase {
    private String description;
    private int shape;
    private boolean productDefinitional;

    public UtilStringIntBoolean(int id, String name, String attribute) {
        super(id, name);
        description = attribute.substring(0, attribute.indexOf("',")).replace("'", "");
        String rest = attribute.substring(attribute.indexOf("',") + 2);
        shape = Integer.parseInt(rest.substring(0, rest.indexOf(",")).replace("#", ""));
        productDefinitional = rest.substring(rest.indexOf(",."), rest.indexOf(".,")).contains("T");
    }

    @Override
    public String toString() {
        return super.toString() +
                ", description='" + description + '\'' +
                ", shape=" + shape +
                ", productDefinitional=" + productDefinitional;
    }
}
