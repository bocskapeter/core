package eu.bopet.jocadv.ie;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.features.Feature;

import java.util.LinkedHashSet;
import java.util.Set;

public class StepFeature implements Feature {
    private RegenerativeLink regenerativeLink;
    private Set<Feature> features;

    public StepFeature(RegenerativeLink regenerativeLink) {
        this.regenerativeLink = regenerativeLink;
        this.features = new LinkedHashSet<>();
    }

    public StepFeature(RegenerativeLink regenerativeLink, Set<Feature> features) {
        this.regenerativeLink = regenerativeLink;
        this.features = features;
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
