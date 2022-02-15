package eu.bopet.jocadv.ie.step;

public class ProductDefinitionFormation extends StepEntity {
    private String description;
    private int productId;

    public ProductDefinitionFormation(String description, int productId) {
        this.description = description;
        this.productId = productId;
    }

    public static ProductDefinitionFormation getInstance(int id, String name, String attribute) {
        String[] values = attribute.split(",");
        String description = values[0].replace("'", "");
        int productId = Integer.parseInt(values[1].substring(1));
        ProductDefinitionFormation productDefinitionFormation =
                new ProductDefinitionFormation(description, productId);
        productDefinitionFormation.setId(id);
        productDefinitionFormation.setName(name);
        return productDefinitionFormation;
    }

    @Override
    public String toString() {
        return "ProductDefinitionFormation{" + super.toString() +
                " description='" + description + '\'' +
                ", productId=" + productId +
                '}';
    }
}
