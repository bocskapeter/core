package eu.bopet.jocadv.core.constraints.regenerative;

import eu.bopet.jocadv.core.features.vector.JoVector;

public class NotOrthogonalVectorException extends Exception {
    private final JoVector vector1;
    private final JoVector vector2;

    public NotOrthogonalVectorException(JoVector vector1, JoVector vector2) {
        this.vector1 = vector1;
        this.vector2 = vector2;
    }

    public JoVector getVector1() {
        return vector1;
    }

    public JoVector getVector2() {
        return vector2;
    }
}
