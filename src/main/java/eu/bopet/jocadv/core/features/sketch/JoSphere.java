package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.features.FeatureBase;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.vector.JoValue;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.ArrayList;
import java.util.List;

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
    public List<JoValue> getValues() {
        List<JoValue> result = new ArrayList<>(center.getValues());
        result.add(radius);
        return result;
    }

    @Override
    public List<JoPoint> getPoints() {
        List<JoPoint> result = new ArrayList<>();
        result.add(center);
        return result;
    }

    @Override
    public String toString() {
        String name = "⦿";
        if (this.getName() != null) name = this.getName();
        return name + "{" + "☉" + center + "R" + radius + '}';
    }
}
