package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.features.FeatureBase;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.JoValue;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.LinkedHashSet;
import java.util.Set;

public class JoSphere extends FeatureBase implements SketchGeometry, Selectable {
    private final JoPoint center;
    private final JoValue radius;

    public JoSphere(JoPoint center, JoValue radius) {
        this.center = center;
        this.radius = radius;
    }

    public JoPoint getCenter() {
        return center;
    }

    public JoValue getRadius() {
        return radius;
    }

    @Override
    public double distance(Line pickingLine) {
        return pickingLine.distance(center.getVector().getVector3D()) - radius.get();
    }

    @Override
    public Set<JoValue> getValues() {
        Set<JoValue> result = new LinkedHashSet<>(center.getValues());
        result.add(radius);
        return result;
    }

    @Override
    public Set<JoPoint> getPoints() {
        Set<JoPoint> result = new LinkedHashSet<>();
        result.add(center);
        return result;
    }

    @Override
    public JoPoint getIntersection(SketchGeometry geometry) {
        return null;
    }

    @Override
    public String toString() {
        String name = "⦿";
        if (this.getName() != null) name = this.getName();
        return name + "{" + "☉" + center + "R" + radius + '}';
    }
}
