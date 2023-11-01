package eu.bopet.jocadv.core.features.basic;

import eu.bopet.jocadv.core.features.JoBaseFeature;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.sketch.JoSValue;
import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.Set;

public class JoFace extends JoBaseFeature implements JoFeature, Selectable {
    private final JoVector normal;
    private final Set<JoFeature> boundary;
    private RegenerativeLink regenerativeLink;

    public JoFace(JoVector normal, Set<JoFeature> boundary, RegenerativeLink regenerativeLink) {
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
    public Set<JoSValue> getValues() {
        Set<JoSValue> result = JoFeature.super.getValues();
        result.addAll(normal.getValues());
        for (JoFeature feature : boundary) {
            result.addAll(feature.getValues());
        }
        return result;
    }

    @Override
    public void store() {
        JoFeature.super.store();
    }

    @Override
    public double distance(Line pickingLine) {
        return 0;
    }

    @Override
    public boolean isOn(JoPoint point) {
        // TODO point on face
        return false;
    }
}
