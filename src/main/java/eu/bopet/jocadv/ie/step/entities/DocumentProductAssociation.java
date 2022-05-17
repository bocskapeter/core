package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringIntInt;

public class DocumentProductAssociation extends UtilStringIntInt {
    public DocumentProductAssociation(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "DocumentProductAssociation{" + super.toString() + "}";
    }
}
