package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringInt;

public class ProductDefinitionFormationWithSpecifiedSource extends UtilStringInt {
    private Source source;

    public ProductDefinitionFormationWithSpecifiedSource(int id, String name, String attribute) {
        super(id, name, attribute);
        source = Source.valueOf(attribute.substring(attribute.lastIndexOf(",") + 1)
                .replace(" ", "").replace(".", ""));
    }

    @Override
    public String toString() {
        return "ProductDefinitionFormationWithSpecifiedSource{" + super.toString() +
                ", source=" + source +
                '}';
    }
}
