package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringIntInt;

import java.util.LinkedHashSet;
import java.util.Set;

public class ItemIdentifiedRepresentationUsage extends UtilStringIntInt {
    private Set<Integer> items;

    public ItemIdentifiedRepresentationUsage(int id, String name, String attribute) {
        super(id, name, attribute);
        items = new LinkedHashSet<>();
        String[] itemStrings = attribute.substring(attribute.lastIndexOf("(") + 1).split(",");
        for (String s : itemStrings) {
            items.add(Integer.parseInt(s.replace("#", "").replace(")", "")));
        }
    }

    @Override
    public String toString() {
        return "ItemIdentifiedRepresentationUsage{" + super.toString() +
                ", items=" + items +
                '}';
    }
}
