package eu.bopet.jocadv.ie.step;

public class ProductCategory extends StepEntity {
    private String description;

    public ProductCategory(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductCategory{" + super.toString() +
                " description='" + description + '\'' +
                '}';
    }
}
