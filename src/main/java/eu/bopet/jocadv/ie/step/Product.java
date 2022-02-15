package eu.bopet.jocadv.ie.step;

import java.util.LinkedHashSet;
import java.util.Set;

public class Product extends StepEntity {
    private String name;
    private String description;
    private Set<Integer> contextIds;

    public Product(String name, String description, Set<Integer> contextIds) {
        this.name = name;
        this.description = description;
        this.contextIds = contextIds;
    }

    public static Product getInstance(int id, String name, String attribute) {
        String[] values = attribute.split(",");
        String secondName = values[0].replace("'", "");
        String description = values[1].replace("'", "");
        Set<Integer> contextIds = new LinkedHashSet<>();
        String substring = attribute.substring(attribute.indexOf("(") + 1, attribute.lastIndexOf(")"));
        String[] contextIdStrings = substring.split(",");
        for (String contextIdString : contextIdStrings) {
            int contextId = Integer.parseInt(contextIdString.substring(1));
            contextIds.add(contextId);
        }
        Product product = new Product(secondName, description, contextIds);
        product.setId(id);
        product.setName(name);
        return product;
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
