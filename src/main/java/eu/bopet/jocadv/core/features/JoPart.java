package eu.bopet.jocadv.core.features;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

public class JoPart {
    private final UUID id;
    private final String name;
    private double tolerance = JoValue.DEFAULT_TOLERANCE;
    private final Set<JoFeature> features;

    public JoPart(UUID id, String name) {
        this.id = id;
        this.name = name;
        features = new LinkedHashSet<>();
    }

    public void addFeature(JoFeature feature) {
        features.add(feature);
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
