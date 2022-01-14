package eu.bopet.jocadv.core.constraints.regenerative.exception;

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

    @Override
    public String toString() {
        return "ParallelVectorException{" +
                "direction1=" + direction1 +
                ", direction2=" + direction2 +
                '}';
    }
}
