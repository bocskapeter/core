package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringInt;

public class DatumReferenceCompartment extends UtilStringInt {
    private final boolean productDefinitional;
    private final int base;
    private final String modifiers;

    public DatumReferenceCompartment(int id, String name, String attribute) {
        super(id, name, attribute);
        String rest = attribute.substring(attribute.indexOf(",.") + 1);
        productDefinitional = rest.substring(rest.indexOf(",")).contains("T");
        String rest2 = rest.substring(rest.indexOf(".,") + 2);
        System.out.println("rest2: " + rest2);
        base = Integer.parseInt(rest2.substring(0, rest2.indexOf(",")).replace("#", ""));
        modifiers = rest2.substring(rest2.indexOf(","));
    }

    @Override
    public String toString() {
        return "DatumReferenceCompartment{" + super.toString() +
                ", productDefinitional=" + productDefinitional +
                ", base=" + base +
                ", modifiers='" + modifiers + '\'' +
                '}';
    }
}
