package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.features.Base;
import eu.bopet.jocadv.core.features.Geometry;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.datums.JoPoint;
import eu.bopet.jocadv.core.features.datums.vector.JoValue;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.ArrayList;
import java.util.List;

public class JoCircle extends Base implements Geometry {
    private final JoSphere sphere;
    private final JoPlane plane;

    public JoCircle(JoSphere sphere, JoPlane plane) {
        this.sphere = sphere;
        this.plane = plane;
    }

    @Override
    public double distance(Line pickingLine) {
        return sphere.distance(pickingLine);
    }

    @Override
    public List<JoValue> getValues() {
        List<JoValue> result = new ArrayList<>();
        result.addAll(sphere.getValues());
        result.addAll(plane.getValues());
        return result;
    }

    @Override
    public List<JoPoint> getPoints() {
        List<JoPoint> result = new ArrayList<>();
        result.addAll(sphere.getPoints());
        return result;
    }
}
