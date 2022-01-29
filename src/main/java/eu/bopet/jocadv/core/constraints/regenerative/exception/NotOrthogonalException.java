package eu.bopet.jocadv.core.constraints.regenerative.exception;

import eu.bopet.jocadv.core.features.Feature;

public class NotOrthogonalException extends Exception {
    private final Feature feature1;
    private final Feature feature2;

    public NotOrthogonalException(Feature feature1, Feature feature2) {
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
