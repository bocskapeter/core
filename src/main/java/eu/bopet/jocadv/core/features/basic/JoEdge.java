package eu.bopet.jocadv.core.features.basic;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.FeatureBase;
import eu.bopet.jocadv.core.features.Selectable;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.Set;

public class JoEdge extends FeatureBase implements Feature, Selectable {
    private Set<JoPoint> points;
    private RegenerativeLink regenerativeLink;

    public JoEdge(Set<JoPoint> points, RegenerativeLink regenerativeLink) {
        this.points = points;
        this.regenerativeLink = regenerativeLink;
    }

    @Override
    public RegenerativeLink getRegenerativeLink() {
        return regenerativeLink;
    }

    @Override
    public void replaceReferenceLink(RegenerativeLink newRegenerativeLink) throws Exception {
        Feature.super.replaceReferenceLink(newRegenerativeLink);
    }

    @Override
    public void setRegenerativeLink(RegenerativeLink newRegenerativeLink) {
        this.regenerativeLink = newRegenerativeLink;
    }

    @Override
    public double distance(Line pickingLine) {
        return 0;
    }
}