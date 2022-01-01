package eu.bopet.jocadv.core.features;

import eu.bopet.jocadv.core.constraints.feature.RegenerativeLink;
import eu.bopet.jocadv.core.features.sketch.SketchGeometry;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.ArrayList;
import java.util.List;

public class JoPoint extends FeatureBase implements SketchGeometry, Selectable, Feature {
    public final static JoPoint ORIGIN = new JoPoint("Origin", JoVector.ZERO, null);
    private final JoVector vector;
    private final RegenerativeLink regenerativeLink;

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
    public List<JoValue> getValues() {
        return vector.getValues();
    }

    @Override
    public List<JoPoint> getPoints() {
        List<JoPoint> result = new ArrayList<>();
        result.add(this);
        return result;
    }

    @Override
    public RegenerativeLink getRegenerativeLink() {
        return regenerativeLink;
    }

    @Override
    public String toString() {
        return "JoPoint{" +
                "vector=" + vector +
                '}';
    }
}
