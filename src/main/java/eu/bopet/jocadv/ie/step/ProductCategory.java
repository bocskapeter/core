package eu.bopet.jocadv.ie.step;

public class ProductCategory extends StepEntity {
    private String description;

    public ProductCategory(String description) {
        this.description = description;
    }

    public static ProductCategory getInstance(int id, String name, String attribute) {
        String description = attribute.replace("'", "").stripLeading();
        ProductCategory productCategory = new ProductCategory(description);
        productCategory.setId(id);
        productCategory.setName(name);
        return productCategory;
    }

    @Override
    public String toString() {
        return "ProductCategory{" + super.toString() +
                " description='" + description + '\'' +
                '}';
    }
}
