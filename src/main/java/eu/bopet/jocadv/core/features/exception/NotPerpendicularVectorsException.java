package eu.bopet.jocadv.core.features.exception;


import eu.bopet.jocadv.core.features.vector.JoVector;

public class NotPerpendicularVectorsException extends Exception {

    private final JoVector x;
    private final JoVector y;

    public NotPerpendicularVectorsException(JoVector x, JoVector y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "NotPerpendicularVectorsException{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
