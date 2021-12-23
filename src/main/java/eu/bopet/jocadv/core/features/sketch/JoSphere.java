package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.features.Base;
import eu.bopet.jocadv.core.features.Geometry;
import eu.bopet.jocadv.core.features.datums.JoPoint;
import eu.bopet.jocadv.core.features.datums.vector.JoValue;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.ArrayList;
import java.util.List;

public class JoSphere extends Base implements Geometry {
    private final JoPoint center;
    private final JoValue radius;

    public JoSphere(JoPoint center, JoValue radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double distance(Line pickingLine) {
        return pickingLine.distance(center.getVector().getVector3D()) - radius.get();
    }

    @Override
    public List<JoValue> getValues() {
        List<JoValue> result = new ArrayList<>();
        result.addAll(center.getValues());
        result.add(radius);
        return result;
    }
}
