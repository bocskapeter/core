package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.StepCode;
import eu.bopet.jocadv.ie.step.util.UtilStringInt;

import java.util.ArrayList;
import java.util.List;

public class DatumReferenceCompartment extends UtilStringInt {
    private final boolean productDefinitional;
    private final List<Integer> bases;
    private final String modifiers;

    public DatumReferenceCompartment(int id, String name, String attribute) {
        super(id, name, attribute);
        String rest = attribute.substring(attribute.indexOf(",.") + 1);
        productDefinitional = rest.substring(0, 3).contains("T");
        String rest2 = rest.substring(rest.indexOf(".,") + 2);
        bases = new ArrayList<>();
        if (rest2.startsWith(StepCode.COMMON_DATUM_LIST)) {
            String[] parts = rest2.substring(rest2.indexOf("("), rest2.lastIndexOf(")")).split(",");
            for (String s : parts) {
                bases.add(Integer.parseInt(s.replace("(", "").replace(")", "")
                        .replace("#", "")));
            }
        } else {
            bases.add(Integer.parseInt(rest2.substring(0, rest2.indexOf(",")).replace("#", "")));
        }
        modifiers = rest2.substring(rest2.lastIndexOf(",") + 1);
    }

    @Override
    public String toString() {
        return "DatumReferenceCompartment{" + super.toString() +
                ", productDefinitional=" + productDefinitional +
                ", bases=" + bases +
                ", modifiers='" + modifiers + '\'' +
                '}';
    }
}
