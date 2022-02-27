package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringInt;

public class ProductDefinitionFormation extends UtilStringInt {

    public ProductDefinitionFormation(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "ProductDefinitionFormation{" + super.toString() + '}';
    }
}
