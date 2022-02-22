package eu.bopet.jocadv.ie.step.context;

import eu.bopet.jocadv.ie.step.context.Context;

public class RepresentationContext extends Context {
    public RepresentationContext(String id, String type) {
        super(id, type);
    }

    @Override
    public String toString() {
        return "RepresentationContext{" + super.toString() + "}";
    }
}
