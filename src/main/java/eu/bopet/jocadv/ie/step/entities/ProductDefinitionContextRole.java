package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilString;

public class ProductDefinitionContextRole extends UtilString {
    public ProductDefinitionContextRole(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "ProductDefinitionContextRole{" + super.toString() + "}";
    }
}
