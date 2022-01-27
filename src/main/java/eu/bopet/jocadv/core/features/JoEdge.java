package eu.bopet.jocadv.core.features;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.Set;

public class JoEdge extends FeatureBase implements Feature, Selectable{
    private Set<JoPoint> points;
    private RegenerativeLink regenerativeLink;


    //TODO complete class

    @Override
    public RegenerativeLink getRegenerativeLink() {
        return null;
    }

    @Override
    public void replaceReferenceLink(RegenerativeLink newRegenerativeLink) throws Exception {
        Feature.super.replaceReferenceLink(newRegenerativeLink);
    }

    @Override
    public void setRegenerativeLink(RegenerativeLink newRegenerativeLink) {

    }

    @Override
    public double distance(Line pickingLine) {
        return 0;
    }
}
