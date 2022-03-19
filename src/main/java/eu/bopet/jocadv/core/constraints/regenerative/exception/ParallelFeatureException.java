package eu.bopet.jocadv.core.constraints.regenerative.exception;

import eu.bopet.jocadv.core.features.JoFeature;

public class ParallelFeatureException extends Exception {
    private final JoFeature feature1;
    private final JoFeature feature2;

    public ParallelFeatureException(JoFeature feature1, JoFeature feature2) {
        this.feature1 = feature1;
        this.feature2 = feature2;
    }

    @Override
    public String toString() {
        return "Parallel Feature Exception{" +
                "1st feature=" + feature1 +
                ", 2nd feature=" + feature2 +
                '}';
    }
}
