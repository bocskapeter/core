package eu.bopet.jocadv.core.constraints.sketch;

import eu.bopet.jocadv.core.features.sketch.JoSValue;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoPlane;

import java.util.ArrayList;
import java.util.List;

public class PointToPlaneDistance extends ConstraintBase implements SketchConstraint {
    private final JoPlane plane;
    private final JoPoint point;
    private final JoSValue distance;

    public PointToPlaneDistance(JoPlane plane, JoPoint point, JoSValue distance, short status) {
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
    public List<JoSValue> getValues() {
        List<JoSValue> result = new ArrayList<>(point.getValues());
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
    public double getDerivative(JoSValue joSValue) {
        if (joSValue == plane.getX()) return point.getVector().getX().get();
        if (joSValue == plane.getY()) return point.getVector().getY().get();
        if (joSValue == plane.getZ()) return point.getVector().getZ().get();
        if (joSValue == point.getVector().getX()) return plane.getX().get();
        if (joSValue == point.getVector().getY()) return plane.getY().get();
        if (joSValue == point.getVector().getZ()) return plane.getZ().get();
        if (joSValue == distance) return 1.0;
        return 0;
    }

    @Override
    public String toString() {
        return "⇤D⇥{" + plane + ", D=" + distance + ", " + point + '}';
    }
}
