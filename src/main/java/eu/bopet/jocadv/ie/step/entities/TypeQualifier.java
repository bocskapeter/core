package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntityBase;

public class TypeQualifier extends StepEntityBase {
    public TypeQualifier(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "TypeQualifier{" + super.toString() + "}";
    }
}
