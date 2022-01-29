package eu.bopet.jocadv.core.features;

import java.util.HashSet;
import java.util.Set;

public class JoPart extends FeatureBase {
    private final Set<Feature> features;

    public JoPart() {
        features = new HashSet<>();
    }

    public void addFeature(Feature feature) {
        if (!features.contains(feature)) {
            features.add(feature);
        }
    }

    public void insertAfter(Feature feature) {

    }

    public void regenerate() throws Exception {
        for (Feature feature : features) {
            if (feature.getRegenerativeLink() != null) feature.getRegenerativeLink().regenerate();
        }
    }
}
