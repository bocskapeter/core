package eu.bopet.jocadv.ie.step;

import java.util.Set;

public class RepresentationsInContext extends StepEntity {
    private Set<Integer> representations;

    public RepresentationsInContext(Set<Integer> representations) {
        this.representations = representations;
    }

    @Override
    public String toString() {
        return "RepresentationsInContext{" + super.toString() +
                " representations=" + representations +
                '}';
    }
}
