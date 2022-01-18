package eu.bopet.jocadv.core.features.protrusion;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.FeatureBase;
import eu.bopet.jocadv.core.features.JoFace;
import eu.bopet.jocadv.core.features.vector.JoValue;

import java.util.Set;

public class JoSolidExtrude extends FeatureBase implements Feature, RegenerativeLink {
    private final JoFace face;
    private final Feature direction;
    private final Feature start;
    private final Feature end;
    private final JoValue pitch;

    public JoSolidExtrude(JoFace face, Feature direction, Feature start, Feature end, JoValue pitch) {
        this.face = face;
        this.direction = direction;
        this.start = start;
        this.end = end;
        if (pitch != null) {
            this.pitch = pitch;
        } else {
            this.pitch = new JoValue(JoValue.AUTO, Double.POSITIVE_INFINITY);
        }
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
    public Set<JoValue> getValues() {
        return Feature.super.getValues();
    }

    @Override
    public void store() {
        Feature.super.store();
    }
}
