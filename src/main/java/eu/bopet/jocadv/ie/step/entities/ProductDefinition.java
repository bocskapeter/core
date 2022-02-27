package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringIntInt;

public class ProductDefinition extends UtilStringIntInt {

    public ProductDefinition(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "ProductDefinition{" + super.toString() + '}';
    }
}
