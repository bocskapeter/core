package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringIntInt;

public class ProductCategoryRelationship extends UtilStringIntInt {
    public ProductCategoryRelationship(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "ProductCategoryRelationship{" + super.toString() + "}";
    }
}
