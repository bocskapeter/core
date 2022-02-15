package eu.bopet.jocadv.ie.step;

import java.util.LinkedHashSet;
import java.util.Set;

public class AdvancedBRepShapeRepresentation extends StepEntity {
    private Set<Integer> itemIds;
    private int contextId;

    public AdvancedBRepShapeRepresentation(Set<Integer> itemIds, int contextId) {
        this.itemIds = itemIds;
        this.contextId = contextId;
    }

    public static AdvancedBRepShapeRepresentation getInstance(int id, String name, String attribute) {
        String substring = attribute.substring(attribute.indexOf("(") + 1, attribute.lastIndexOf(")"));
        String[] itemIdStrings = substring.split(",");
        Set<Integer> itemIds = new LinkedHashSet<>();
        for (String itemIdString : itemIdStrings) {
            int itemId = Integer.parseInt(itemIdString.substring(1));
            itemIds.add(itemId);
        }
        String contextIdString = attribute.substring(attribute.lastIndexOf(",") + 1);
        int contextId = Integer.parseInt(contextIdString.substring(1));
        AdvancedBRepShapeRepresentation advancedBRepShapeRepresentation = new
                AdvancedBRepShapeRepresentation(itemIds, contextId);
        advancedBRepShapeRepresentation.setId(id);
        advancedBRepShapeRepresentation.setName(name);
        return advancedBRepShapeRepresentation;
    }

    @Override
    public String toString() {
        return "AdvancedBRepShapeRepresentation{" + super.toString() +
                " itemIds=" + itemIds +
                ", contextId=" + contextId +
                '}';
    }
}
