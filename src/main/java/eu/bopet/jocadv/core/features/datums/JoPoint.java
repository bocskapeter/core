package eu.bopet.jocadv.core.features.datums;

import eu.bopet.jocadv.core.features.Base;
import eu.bopet.jocadv.core.features.Geometry;
import eu.bopet.jocadv.core.features.datums.vector.JoValue;
import eu.bopet.jocadv.core.features.datums.vector.JoVector;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.ArrayList;
import java.util.List;

public class JoPoint extends Base implements Geometry {
    public final static JoPoint ORIGIN = new JoPoint(JoVector.ZERO);
    private final JoVector vector;

    public JoPoint(JoVector vector) {
        this.vector = vector;
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
}
