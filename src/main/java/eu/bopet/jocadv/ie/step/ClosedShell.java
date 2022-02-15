package eu.bopet.jocadv.ie.step;

import java.util.LinkedHashSet;
import java.util.Set;

public class ClosedShell extends StepEntity {
    private Set<Integer> faceIds;

    public ClosedShell(Set<Integer> faceIds) {
        this.faceIds = faceIds;
    }

    public static ClosedShell getInstance(int id, String name, String attribute) {
        String bracket = attribute.substring(attribute.indexOf("(") + 1, attribute.lastIndexOf(")"))
                .replaceAll(" ", "");
        String[] values = bracket.split(",");
        Set<Integer> faceIds = new LinkedHashSet<>();
        for (String value : values) {
            int faceId = Integer.parseInt(value.substring(1));
            faceIds.add(faceId);
        }
        ClosedShell closedShell = new ClosedShell(faceIds);
        closedShell.setId(id);
        closedShell.setName(name);
        return closedShell;
    }

    @Override
    public String toString() {
        return "ClosedShell{" + super.toString() +
                " faceIds=" + faceIds +
                '}';
    }
}
