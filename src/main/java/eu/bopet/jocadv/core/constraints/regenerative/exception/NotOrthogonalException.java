package eu.bopet.jocadv.core.constraints.regenerative.exception;

import eu.bopet.jocadv.core.features.JoFeature;

public class NotOrthogonalException extends Exception {
    private final JoFeature feature1;
    private final JoFeature feature2;

    public NotOrthogonalException(JoFeature feature1, JoFeature feature2) {
        this.feature1 = feature1;
        this.feature2 = feature2;
    }

    @Override
    public String toString() {
        return "Not Orthogonal features Exception{" +
                "1st vector=" + feature1 +
                ", 2nd vector=" + feature2 +
                '}';
    }
}
