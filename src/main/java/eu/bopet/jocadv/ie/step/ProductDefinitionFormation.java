package eu.bopet.jocadv.ie.step;

public class ProductDefinitionFormation extends StepEntity {
    private String description;
    private int productId;

    public ProductDefinitionFormation(String description, int productId) {
        this.description = description;
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ProductDefinitionFormation{" + super.toString() +
                " description='" + description + '\'' +
                ", productId=" + productId +
                '}';
    }
}
