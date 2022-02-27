package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringInt;

public class ProductDefinitionShape extends UtilStringInt {

    public ProductDefinitionShape(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "ProductDefinitionShape{" + super.toString() + '}';
    }
}
