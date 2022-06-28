package eu.bopet.jocadv.core.features;

import java.util.HashSet;
import java.util.Set;

public class JoPart extends FeatureBase {
    private final Set<JoFeature> features;

    public JoPart() {
        features = new HashSet<>();
    }

    public void addFeature(JoFeature feature) {
        if (!features.contains(feature)) {
            features.add(feature);
        }
    }

    public Set<JoFeature> getFeatures() {
        return features;
    }

    public void insertAfter(JoFeature feature) {

    }

    public void regenerate() throws Exception {
        for (JoFeature feature : features) {
            if (feature.getRegenerativeLink() != null) feature.getRegenerativeLink().regenerate();
        }
    }
}
