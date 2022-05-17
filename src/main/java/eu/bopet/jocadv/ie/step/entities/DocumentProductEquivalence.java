package eu.bopet.jocadv.ie.step.entities;

public class DocumentProductEquivalence extends DocumentProductAssociation {
    public DocumentProductEquivalence(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "DocumentProductEquivalence{" + super.toString() + "}";
    }
}
