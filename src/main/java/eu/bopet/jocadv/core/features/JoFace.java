package eu.bopet.jocadv.core.features;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.features.vector.JoValue;

import java.util.Set;

public class JoFace extends FeatureBase implements Feature, RegenerativeLink {
    @Override
    public void regenerate() throws Exception {

    }

    @Override
    public Feature getResult() {
        return null;
    }

    @Override
    public RegenerativeLink getRegenerativeLink() {
        return null;
    }

    @Override
    public void setRegenerativeLink(RegenerativeLink newRegenerativeLink) {

    }

    @Override
    public Set<JoValue> getValues() {
        return Feature.super.getValues();
    }

    @Override
    public void store() {
        Feature.super.store();
    }
}
