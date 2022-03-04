package eu.bopet.jocadv.ie.step.unit;

import eu.bopet.jocadv.ie.step.util.StepCode;
import eu.bopet.jocadv.ie.step.util.StepEntityBase;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Units extends StepEntityBase {
    private Set<Unit> units;

    public Units(int id, String name, String set) {
        super(id, name);
        units = new LinkedHashSet<>();
        System.out.println("Set Unit: " + set);
        List<String> unitStringList = StepEntityBase.getSets(set, StepCode.UNITS);
        for (String s : unitStringList) {
            System.out.println("s: " + s);
            for (String code : StepCode.CURVES) {
                if (s.startsWith(code)) {
                    String attributes = s.substring(s.indexOf("(") + 1, s.lastIndexOf(")"));
                    switch (code) {
                        case StepCode.CONVERSION_BASED_UNIT: {

                        }
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Units{" +
                "units=" + units +
                '}';
    }
}
