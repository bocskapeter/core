package eu.bopet.jocadv.core.constraints.sketch;

import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoPlane;

import java.util.ArrayList;
import java.util.List;

public class PointToPlaneDistance extends ConstraintBase implements SketchConstraint {
    private final JoPlane plane;
    private final JoPoint point;
    private final JoValue distance;

    public PointToPlaneDistance(JoPlane plane, JoPoint point, JoValue distance, short status) {
        super(status);
        this.plane = plane;
        this.point = point;
        this.distance = distance;
    }

    @Override
    public List<Object> getComponents() {
        List<Object> result = new ArrayList<>();
        result.add(plane);
        result.add(point);
        result.add(distance);
        return result;
    }

    @Override
    public List<JoValue> getValues() {
        List<JoValue> result = new ArrayList<>(point.getValues());
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

    @Override
    public String toString() {
        return "⇤D⇥{" + plane + ", D=" + distance + ", " + point + '}';
    }
}
