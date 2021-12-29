package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.features.FeatureBase;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.vector.JoValue;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.ArrayList;
import java.util.List;

public class JoArc extends FeatureBase implements SketchGeometry, Selectable {
    private final JoCircle circle;
    private final JoPoint point1;
    private final JoPoint point2;

    public JoArc(JoCircle circle, JoPoint point1, JoPoint point2) {
        this.circle = circle;
        this.point1 = point1;
        this.point2 = point2;
    }

    @Override
    public double distance(Line pickingLine) {
        return circle.distance(pickingLine);
    }

    @Override
    public List<JoValue> getValues() {
        List<JoValue> result = new ArrayList<>(circle.getValues());
        result.addAll(point1.getValues());
        result.addAll(point2.getValues());
        return result;
    }

    @Override
    public List<JoPoint> getPoints() {
        List<JoPoint> result = new ArrayList<>(circle.getPoints());
        result.add(point1);
        result.add(point2);
        return result;
    }
}
