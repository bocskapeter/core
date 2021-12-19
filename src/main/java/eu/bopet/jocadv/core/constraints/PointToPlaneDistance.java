package eu.bopet.jocadv.core.constraints;

import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.datums.JoPoint;
import eu.bopet.jocadv.core.features.datums.vector.JoValue;

import java.util.ArrayList;
import java.util.List;

public class PointToPlaneDistance implements Constraint {
    private final JoPlane plane;
    private final JoPoint point;
    private final JoValue distance;

    public PointToPlaneDistance(JoPlane plane, JoPoint point, JoValue distance) {
        this.plane = plane;
        this.point = point;
        this.distance = distance;
    }

    @Override
    public List<JoValue> getValues() {
        List<JoValue> result = new ArrayList<>();
        result.addAll(plane.getValues());
        result.addAll(point.getValues());
        result.add(distance);
        return result;
    }

    @Override
    public double getFunctionValue() {
        return plane.getX().get() * point.getVector().getX().get() +
                plane.getY().get() * point.getVector().getY().get() +
                plane.getZ().get() * point.getVector().getZ().get() +
                plane.getD().get() - distance.get();
    }

    @Override
    public double getDerivative(JoValue joValue) {
        if (joValue == plane.getX()) return point.getVector().getX().get();
        if (joValue == plane.getY()) return point.getVector().getY().get();
        if (joValue == plane.getZ()) return point.getVector().getZ().get();
        if (joValue == point.getVector().getX()) return plane.getX().get();
        if (joValue == point.getVector().getY()) return plane.getY().get();
        if (joValue == point.getVector().getZ()) return plane.getZ().get();
        if (joValue == distance) return 1.0;
        return 0;
    }
}
