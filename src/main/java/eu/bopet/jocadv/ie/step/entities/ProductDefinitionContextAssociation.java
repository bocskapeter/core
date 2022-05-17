package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilIntIntInt;

public class ProductDefinitionContextAssociation extends UtilIntIntInt {
    public ProductDefinitionContextAssociation(int id, String name, String attributes) {
        super(id, name, attributes);
    }

    @Override
    public String toString() {
        return "ProductDefinitionContextAssociation{" + super.toString() + "}";
    }
}
