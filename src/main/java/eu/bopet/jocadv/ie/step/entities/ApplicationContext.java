package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.StepEntityBase;

public class ApplicationContext extends StepEntityBase {

    public ApplicationContext(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "ApplicationContext{" + super.toString() + '}';
    }
}
