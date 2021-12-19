package eu.bopet.jocadv.core.features.datums;

import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.Geometry;
import eu.bopet.jocadv.core.features.datums.vector.JoValue;
import eu.bopet.jocadv.core.features.datums.vector.JoVector;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.ArrayList;
import java.util.List;

public class JoAxis extends Feature implements Geometry {
    public static final JoAxis X = new JoAxis(JoPoint.ORIGIN, JoVector.I);
    public static final JoAxis Y = new JoAxis(JoPoint.ORIGIN, JoVector.J);
    public static final JoAxis Z = new JoAxis(JoPoint.ORIGIN, JoVector.K);
    private final JoPoint point;
    private final JoVector direction;

    public JoAxis(JoPoint point, JoVector direction) {
        this.point = point;
        this.direction = direction;
    }

    @Override
    public double distance(Line pickingLine) {
        return 0;
    }

    @Override
    public List<JoValue> getValues() {
        List<JoValue> result = new ArrayList<>();
        result.addAll(point.getValues());
        result.addAll(direction.getValues());
        return result;
    }
}
