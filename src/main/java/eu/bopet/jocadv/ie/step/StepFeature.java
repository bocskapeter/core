package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.features.JoFeature;

import java.util.LinkedHashSet;
import java.util.Set;

public class StepFeature implements JoFeature {
    private RegenerativeLink regenerativeLink;
    private Set<JoFeature> features;

    public StepFeature(RegenerativeLink regenerativeLink) {
        this.regenerativeLink = regenerativeLink;
        this.features = new LinkedHashSet<>();
    }

    public StepFeature(RegenerativeLink regenerativeLink, Set<JoFeature> features) {
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
