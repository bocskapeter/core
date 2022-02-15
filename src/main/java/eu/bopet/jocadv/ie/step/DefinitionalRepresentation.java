package eu.bopet.jocadv.ie.step;

import java.util.LinkedHashSet;
import java.util.Set;

public class DefinitionalRepresentation extends StepEntity {
    private Set<Integer> itemIds;
    private int contextId;

    public DefinitionalRepresentation(Set<Integer> itemIds, int contextId) {
        this.itemIds = itemIds;
        this.contextId = contextId;
    }

    public static DefinitionalRepresentation getInstance(int id, String name, String attribute) {
        String substring = attribute.substring(attribute.indexOf("(") + 1, attribute.lastIndexOf(")"));
        String[] items = substring.split(",");
        Set<Integer> itemIds = new LinkedHashSet<>();
        for (String item : items) {
            itemIds.add(Integer.parseInt(item.substring(1)));
        }
        String last = attribute.substring(attribute.lastIndexOf(",") + 1);
        int contextId = Integer.parseInt(last.substring(1));
        DefinitionalRepresentation definitionalRepresentation
                = new DefinitionalRepresentation(itemIds, contextId);
        definitionalRepresentation.setId(id);
        definitionalRepresentation.setName(name);
        return definitionalRepresentation;
    }

    @Override
    public String toString() {
        return "DefinitionalRepresentation{" + super.toString() +
                " itemIds=" + itemIds +
                ", contextId=" + contextId +
                '}';
    }
}
