package eu.bopet.jocadv.core.features;

import java.util.ArrayList;
import java.util.List;

public class JoPart extends FeatureBase {
    private final List<Feature> features;

    public JoPart() {
        features = new ArrayList<>();
    }

    public void addFeature(Feature feature) {
        if (!features.contains(feature)) {
            features.add(feature);
        }
    }

    public void regenerate() throws Exception {
        for (Feature feature : features) {
            if (feature.getRegenerativeLink() != null) feature.getRegenerativeLink().regenerate();
        }
    }
}
