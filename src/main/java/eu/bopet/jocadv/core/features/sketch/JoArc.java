package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.features.Base;
import eu.bopet.jocadv.core.features.Geometry;
import eu.bopet.jocadv.core.features.datums.JoPoint;
import eu.bopet.jocadv.core.features.datums.vector.JoValue;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.ArrayList;
import java.util.List;

public class JoArc extends Base implements Geometry {
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
        List<JoValue> result = new ArrayList<>();
        result.addAll(circle.getValues());
        result.addAll(point1.getValues());
        result.addAll(point2.getValues());
        return result;
    }
}
