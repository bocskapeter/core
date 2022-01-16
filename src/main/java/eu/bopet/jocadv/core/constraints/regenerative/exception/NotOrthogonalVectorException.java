package eu.bopet.jocadv.core.constraints.regenerative.exception;

import eu.bopet.jocadv.core.features.vector.JoVector;

public class NotOrthogonalVectorException extends Exception {
    private final JoVector vector1;
    private final JoVector vector2;

    public NotOrthogonalVectorException(JoVector vector1, JoVector vector2) {
        this.vector1 = vector1;
        this.vector2 = vector2;
    }

    @Override
    public String toString() {
        return "Not Orthogonal Vector Exception{" +
                "1st vector=" + vector1 +
                ", 2nd vector=" + vector2 +
                '}';
    }
}
