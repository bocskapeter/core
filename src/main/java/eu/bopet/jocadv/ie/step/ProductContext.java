package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.ie.step.util.UtilIntString;

public class ProductContext extends UtilIntString {

    public ProductContext(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "ProductDefinitionContext{" + super.toString() + '}';
    }
}
