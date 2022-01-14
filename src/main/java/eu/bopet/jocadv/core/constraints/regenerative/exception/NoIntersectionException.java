package eu.bopet.jocadv.core.constraints.regenerative.exception;

import eu.bopet.jocadv.core.features.vector.JoVector;

public class NoIntersectionException extends Exception {
    private final JoVector vector1;
    private final JoVector vector2;

    public NoIntersectionException(JoVector vector1, JoVector vector2) {
        this.vector1 = vector1;
        this.vector2 = vector2;
    }

    public JoVector getVector1() {
        return vector1;
    }

    public JoVector getVector2() {
        return vector2;
    }

    @Override
    public String toString() {
        return "NoIntersectionException{" +
                "vector1=" + vector1 +
                ", vector2=" + vector2 +
                '}';
    }
}
