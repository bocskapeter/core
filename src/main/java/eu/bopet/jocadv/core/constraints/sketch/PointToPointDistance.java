package eu.bopet.jocadv.core.constraints.sketch;

import eu.bopet.jocadv.core.features.sketch.JoSValue;
import eu.bopet.jocadv.core.features.basic.JoPoint;

import java.util.ArrayList;
import java.util.List;

public class PointToPointDistance extends ConstraintBase implements SketchConstraint {
    private final JoPoint point1;
    private final JoPoint point2;
    private final JoSValue distance;

    public PointToPointDistance(JoPoint point1, JoPoint point2, JoSValue distance, short status) {
        super(status);
        this.point1 = point1;
        this.point2 = point2;
        this.distance = distance;
    }

    @Override
    public List<Object> getComponents() {
        List<Object> result = new ArrayList<>();
        result.add(point1);
        result.add(point2);
        result.add(distance);
        return result;
    }

    @Override
    public List<JoSValue> getValues() {
        List<JoSValue> result = new ArrayList<>();
        result.addAll(point1.getValues());
        result.addAll(point2.getValues());
        result.add(distance);
        return result;
    }

    @Override
    public double getFunctionValue() {
        return distance() - distance.get();
    }

    private double distance() {
        double x = point2.getVector().getX().get() - point1.getVector().getX().get();
        double y = point2.getVector().getY().get() - point1.getVector().getY().get();
        double z = point2.getVector().getZ().get() - point1.getVector().getZ().get();
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public double getDerivative(JoSValue joSValue) {
        if (joSValue == point1.getVector().getX())
            return -1.0 * (point2.getVector().getX().get() - point1.getVector().getX().get()) / distance();
        if (joSValue == point2.getVector().getX())
            return -1.0 * (point1.getVector().getX().get() - point2.getVector().getX().get()) / distance();
        if (joSValue == point1.getVector().getY())
            return -1.0 * (point2.getVector().getY().get() - point1.getVector().getY().get()) / distance();
        if (joSValue == point2.getVector().getY())
            return -1.0 * (point1.getVector().getY().get() - point2.getVector().getY().get()) / distance();
        if (joSValue == point1.getVector().getZ())
            return -1.0 * (point2.getVector().getZ().get() - point1.getVector().getZ().get()) / distance();
        if (joSValue == point2.getVector().getZ())
            return -1.0 * (point1.getVector().getZ().get() - point2.getVector().getZ().get()) / distance();
        if (joSValue == distance) return -1.0;
        return 0.0;
    }

    @Override
    public String toString() {
        return "⇤D⇥{" + point1 + ", D=" + distance + ", " + point2 + '}';
    }
}
