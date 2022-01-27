package eu.bopet.jocadv.core.constraints.regenerative.exception;

import eu.bopet.jocadv.core.features.Feature;

public class NoIntersectionException extends Exception {
    private final Feature feature1;
    private final Feature feature2;

    public NoIntersectionException(Feature feature1, Feature feature2) {
        this.feature1 = feature1;
        this.feature2 = feature2;
    }

    @Override
    public String toString() {
        return "No Intersection Exception{" +
                "1st feature=" + feature1 +
                ", 2nd feature=" + feature2 +
                '}';
    }
}
