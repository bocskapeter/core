package eu.bopet.jocadv.core.features.basic;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.FeatureBase;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.Set;

public class JoFace extends FeatureBase implements Feature, Selectable {
    private final JoVector normal;
    private final Set<Feature> boundary;
    private RegenerativeLink regenerativeLink;

    public JoFace(JoVector normal, Set<Feature> boundary, RegenerativeLink regenerativeLink) {
        this.normal = normal;
        this.boundary = boundary;
        this.regenerativeLink = regenerativeLink;
    }

    @Override
    public RegenerativeLink getRegenerativeLink() {
        return regenerativeLink;
    }

    @Override
    public void setRegenerativeLink(RegenerativeLink newRegenerativeLink) {
        this.regenerativeLink = newRegenerativeLink;
    }

    @Override
    public Set<JoValue> getValues() {
        Set<JoValue> result = Feature.super.getValues();
        result.addAll(normal.getValues());
        for (Feature feature : boundary) {
            result.addAll(feature.getValues());
        }
        return result;
    }

    @Override
    public void store() {
        Feature.super.store();
    }

    @Override
    public double distance(Line pickingLine) {
        return 0;
    }
}
