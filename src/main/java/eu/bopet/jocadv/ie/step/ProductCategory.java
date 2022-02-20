package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.ie.step.util.UtilString;

public class ProductCategory extends UtilString {

    public ProductCategory(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "ProductCategory{" + super.toString() + '}';
    }
}
