package eu.bopet.jocadv.core.features.basic;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.FeatureBase;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.sketch.SketchGeometry;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.LinkedHashSet;
import java.util.Set;

public class JoPoint extends FeatureBase implements SketchGeometry, Selectable, JoFeature {
    public final static JoPoint ORIGIN = new JoPoint("Origin", JoVector.ZERO, null);
    private final JoVector vector;
    private RegenerativeLink regenerativeLink;

    public JoPoint(JoVector vector, RegenerativeLink regenerativeLink) {
        this.vector = vector;
        this.regenerativeLink = regenerativeLink;
    }

    public JoPoint(String name, JoVector vector, RegenerativeLink regenerativeLink) {
        super();
        super.setName(name);
        this.vector = vector;
        this.regenerativeLink = regenerativeLink;
    }

    public JoVector getVector() {
        return vector;
    }

    public double distance(JoPoint point) {
        return vector.getVector3D().distance(point.vector.getVector3D());
    }

    @Override
    public double distance(Line pickingLine) {
        return pickingLine.distance(vector.getVector3D());
    }

    @Override
    public Set<JoValue> getValues() {
        Set<JoValue> result = JoFeature.super.getValues();
        result.addAll(vector.getValues());
        return result;
    }

    @Override
    public void store() {
        JoFeature.super.store();
        this.vector.store();
    }

    @Override
    public Set<JoPoint> getPoints() {
        Set<JoPoint> result = new LinkedHashSet<>();
        result.add(this);
        return result;
    }

    @Override
    public JoPoint getIntersection(SketchGeometry geometry) {
        return null;
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
    public String toString() {
        String name = "·";
        if (this.getName() != null) name = this.getName();
        return name + "{" + vector + '}';
    }
}
