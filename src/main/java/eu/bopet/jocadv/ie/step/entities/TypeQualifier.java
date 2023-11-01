package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntity;

public class TypeQualifier extends StepEntity {
    public TypeQualifier(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "TypeQualifier{" + super.toString() + "}";
    }
}
