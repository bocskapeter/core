package eu.bopet.jocadv.ie.step;

public class ProductDefinitionShape extends StepEntity {
    private String description;
    private int definition;

    public ProductDefinitionShape(String description, int definition) {
        this.description = description;
        this.definition = definition;
    }

    @Override
    public String toString() {
        return "ProductDefinitionShape{" + super.toString() +
                " description='" + description + '\'' +
                ", definition=" + definition +
                '}';
    }
}
