package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.ie.step.util.StepEntity;

public class ApplicationContext extends StepEntity {

    public ApplicationContext(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "ApplicationContext{" + super.toString() + '}';
    }
}
