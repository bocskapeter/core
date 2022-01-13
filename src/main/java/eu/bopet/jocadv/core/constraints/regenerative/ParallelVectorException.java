package eu.bopet.jocadv.core.constraints.regenerative;

import eu.bopet.jocadv.core.features.vector.JoVector;

public class ParallelVectorException extends Exception {
    private final JoVector direction1;
    private final JoVector direction2;

    public ParallelVectorException(JoVector direction1, JoVector direction2) {
        this.direction1 = direction1;
        this.direction2 = direction2;
    }

    public JoVector getDirection1() {
        return direction1;
    }

    public JoVector getDirection2() {
        return direction2;
    }
}
