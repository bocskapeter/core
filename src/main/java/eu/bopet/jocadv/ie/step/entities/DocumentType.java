package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntity;

public class DocumentType extends StepEntity {
    public DocumentType(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "DocumentType{" + super.toString() + "}";
    }
}
