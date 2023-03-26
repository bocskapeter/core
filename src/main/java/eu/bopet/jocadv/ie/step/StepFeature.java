package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.RegenerativeLink;

import java.util.Set;

public class StepFeature implements JoFeature {
    private RegenerativeLink regenerativeLink;
    private Set<JoFeature> features;

    public StepFeature(RegenerativeLink regenerativeLink, Set<JoFeature> features) {
        this.regenerativeLink = regenerativeLink;
        this.features = features;
    }

    public Set<JoFeature> getFeatures() {
        return features;
    }

    @Override
    public RegenerativeLink getRegenerativeLink() {
        return regenerativeLink;
    }

    @Override
    public void setRegenerativeLink(RegenerativeLink newRegenerativeLink) {
        this.regenerativeLink = newRegenerativeLink;
    }
}
