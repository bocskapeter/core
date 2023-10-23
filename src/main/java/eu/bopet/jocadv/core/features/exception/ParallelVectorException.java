package eu.bopet.jocadv.core.features.exception;

import eu.bopet.jocadv.core.features.vector.JoVector;

public class ParallelVectorException extends Exception {
    private final JoVector x;
    private final JoVector y;

    public ParallelVectorException(JoVector x, JoVector y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "ParallelVectorException{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
