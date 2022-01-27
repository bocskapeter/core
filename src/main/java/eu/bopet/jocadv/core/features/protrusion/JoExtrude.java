package eu.bopet.jocadv.core.features.protrusion;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.FeatureBase;
import eu.bopet.jocadv.core.features.basic.JoFace;
import eu.bopet.jocadv.core.features.vector.JoValue;

import java.util.Set;

public class JoExtrude extends FeatureBase implements Feature, RegenerativeLink {
    private final JoFace face;
    private final Feature path;
    private final Feature start;
    private final Feature end;
    private final JoValue pitch;
    private final RegenerativeLink regenerativeLink;

    public JoExtrude(JoFace face, Feature path, Feature start, Feature end, JoValue pitch, RegenerativeLink regenerativeLink) {
        this.face = face;
        this.path = path;
        this.start = start;
        this.end = end;
        if (pitch != null) {
            this.pitch = pitch;
        } else {
            this.pitch = new JoValue(JoValue.AUTO, Double.POSITIVE_INFINITY);
        }
        this.regenerativeLink = regenerativeLink;
    }

    @Override
    public void regenerate() {
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
