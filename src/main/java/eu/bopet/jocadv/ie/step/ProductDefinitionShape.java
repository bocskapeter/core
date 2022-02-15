package eu.bopet.jocadv.ie.step;

public class ProductDefinitionShape extends StepEntity {
    private String description;
    private int definition;

    public ProductDefinitionShape(String description, int definition) {
        this.description = description;
        this.definition = definition;
    }

    public static ProductDefinitionShape getInstance(int id, String name, String attribute) {
        String[] values = attribute.split(",");
        String description = values[0].replace("'", "");
        int definition = Integer.parseInt(values[1].substring(1));
        ProductDefinitionShape productDefinitionShape =
                new ProductDefinitionShape(description, definition);
        productDefinitionShape.setId(id);
        productDefinitionShape.setName(name);
        return productDefinitionShape;
    }

    @Override
    public String toString() {
        return "ProductDefinitionShape{" + super.toString() +
                " description='" + description + '\'' +
                ", definition=" + definition +
                '}';
    }
}
