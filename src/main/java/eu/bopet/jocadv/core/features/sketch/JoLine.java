package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.Geometry;
import eu.bopet.jocadv.core.features.datums.JoPoint;
import eu.bopet.jocadv.core.features.datums.vector.JoValue;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.ArrayList;
import java.util.List;

public class JoLine extends Feature implements Geometry {
    private final JoPoint point1;
    private final JoPoint point2;

    public JoLine(JoPoint point1, JoPoint point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    @Override
    public double distance(Line pickingLine) {
        return pickingLine.distance(geLine());
    }

    private Line geLine() {
        return new Line(point1.getVector().getVector3D(), point2.getVector().getVector3D(), JoValue.DEFAULT_TOLERANCE);
    }

    @Override
    public List<JoValue> getValues() {
        List<JoValue> result = new ArrayList<>();
        result.addAll(point1.getValues());
        result.addAll(point2.getValues());
        return result;
    }
}
