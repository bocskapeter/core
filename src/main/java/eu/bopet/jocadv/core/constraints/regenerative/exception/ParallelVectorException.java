package eu.bopet.jocadv.core.constraints.regenerative.exception;

import eu.bopet.jocadv.core.features.vector.JoVector;

public class ParallelVectorException extends Exception {
    private final JoVector vector1;
    private final JoVector vector2;

    public ParallelVectorException(JoVector vector1, JoVector vector2) {
        this.vector1 = vector1;
        this.vector2 = vector2;
    }

    @Override
    public String toString() {
        return "Parallel Vector Exception{" +
                "1st vector=" + vector1 +
                ", 2nd vector=" + vector2 +
                '}';
    }
}
