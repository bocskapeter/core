package eu.bopet.jocadv.ie.step;

import java.util.LinkedHashSet;
import java.util.Set;

public class AdvancedFace extends StepEntity {
    private Set<Integer> boundIds;
    private int surfaceId;
    private boolean sameSense;

    public AdvancedFace(Set<Integer> boundIds, int surfaceId, boolean sameSense) {
        this.boundIds = boundIds;
        this.surfaceId = surfaceId;
        this.sameSense = sameSense;
    }

    public static AdvancedFace getInstance(int id, String name, String attribute) {
        String substring = attribute.substring(attribute.indexOf("(") + 1, attribute.lastIndexOf(")"));
        String[] values = substring.split(",");
        Set<Integer> boundIds = new LinkedHashSet<>();
        for (String value : values) {
            boundIds.add(Integer.parseInt(value.substring(1)));
        }
        String[] rest = (attribute.substring(attribute.indexOf(")") + 1)).split(",");
        int surfaceId = Integer.parseInt(rest[1].substring(1));
        boolean sameSense = rest[2].contains("T");
        AdvancedFace advancedFace = new AdvancedFace(boundIds, surfaceId, sameSense);
        advancedFace.setId(id);
        advancedFace.setName(name);
        return advancedFace;
    }

    @Override
    public String toString() {
        return "AdvancedFace{" + super.toString() +
                " boundIds=" + boundIds +
                ", surfaceId=" + surfaceId +
                ", sameSense=" + sameSense +
                '}';
    }
}
