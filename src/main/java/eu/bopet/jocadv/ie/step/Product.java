package eu.bopet.jocadv.ie.step;

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

    @Override
    public String toString() {
        return "Product{" + super.toString() +
                " 2nd name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", contextIds=" + contextIds +
                '}';
    }
}
