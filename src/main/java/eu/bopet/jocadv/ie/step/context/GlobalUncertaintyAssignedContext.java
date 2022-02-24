package eu.bopet.jocadv.ie.step.context;

import java.util.LinkedHashSet;
import java.util.Set;

public class GlobalUncertaintyAssignedContext extends Context {
    private Set<Integer> units;

    public GlobalUncertaintyAssignedContext(String id, String type, String attribute) {
        super(id, type);
        units = new LinkedHashSet<>();
        String[] unitStrings = attribute.replace("(", "").replace(")", "")
                .replace("#", "")
                .split(",");
        for (String unitString : unitStrings) {
            int unitId = Integer.parseInt(unitString);
            units.add(unitId);
        }
    }

    @Override
    public String toString() {
        return "GlobalUncertaintyAssignedContext{" + super.toString() +
                " units=" + units +
                '}';
    }
}
