package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.ie.step.util.StepEntity;

import java.util.LinkedHashSet;
import java.util.Set;

public class Product extends StepEntity {
    private String name;
    private String description;
    private Set<Integer> contextIds;

    public Product(int id, String name, String attribute) {
        super(id, name);
        String[] values = attribute.split(",");
        this.name = values[0].replace("'", "");
        description = values[1].replace("'", "");
        contextIds = new LinkedHashSet<>();
        String substring = attribute.substring(attribute.indexOf("(") + 1, attribute.lastIndexOf(")"));
        String[] contextIdStrings = substring.split(",");
        for (String contextIdString : contextIdStrings) {
            int contextId = Integer.parseInt(contextIdString.substring(1));
            contextIds.add(contextId);
        }
    }

    @Override
    public String toString() {
        return "Product{" + super.toString() +
                " 2nd name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", contextIds=" + contextIds +
                '}';
    }
}
