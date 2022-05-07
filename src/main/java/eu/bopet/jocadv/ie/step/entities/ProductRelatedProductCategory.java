package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntityBase;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class ProductRelatedProductCategory extends StepEntityBase {
    private ProductCategory productCategory;
    private Set<Integer> products;

    public ProductRelatedProductCategory(int id, String name, String attributes) {
        super(id, name);
        String[] parts = attributes.split(",");
        productCategory = new ProductCategory(-1, parts[0].replace("'", ""), parts[1]);
        String[] thirdParts = attributes.split(Pattern.quote(",("));
        String[] productStrings = thirdParts[1].split(",");
        products = new LinkedHashSet<>();
        for (String s : productStrings) {
            products.add(Integer.parseInt(s.replace("#", "").replace(")", "")));
        }
    }

    @Override
    public String toString() {
        return "ProductRelatedProductCategory{" + super.toString() +
                ", productCategory=" + productCategory +
                ", products=" + products +
                '}';
    }
}
