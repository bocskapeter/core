package eu.bopet.jocadv.core.constraints;

import eu.bopet.jocadv.core.features.datums.JoPoint;
import eu.bopet.jocadv.core.features.datums.vector.JoValue;

import java.util.ArrayList;
import java.util.List;

public class PointToPointDistance implements Constraint {
    private final JoPoint point1;
    private final JoPoint point2;
    private final JoValue distance;

    public PointToPointDistance(JoPoint point1, JoPoint point2, JoValue distance) {
        this.point1 = point1;
        this.point2 = point2;
        this.distance = distance;
    }

    @Override
    public List<JoValue> getValues() {
        List<JoValue> result = new ArrayList<>();
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
    public double getDerivative(JoValue joValue) {
        if (joValue == point1.getVector().getX())
            return -1.0 * (point2.getVector().getX().get() - point1.getVector().getX().get()) / distance();
        if (joValue == point2.getVector().getX())
            return -1.0 * (point1.getVector().getX().get() - point2.getVector().getX().get()) / distance();
        if (joValue == point1.getVector().getY())
            return -1.0 * (point2.getVector().getY().get() - point1.getVector().getY().get()) / distance();
        if (joValue == point2.getVector().getY())
            return -1.0 * (point1.getVector().getY().get() - point2.getVector().getY().get()) / distance();
        if (joValue == point1.getVector().getZ())
            return -1.0 * (point2.getVector().getZ().get() - point1.getVector().getZ().get()) / distance();
        if (joValue == point2.getVector().getZ())
            return -1.0 * (point1.getVector().getZ().get() - point2.getVector().getZ().get()) / distance();
        if (joValue == distance) return -1.0;
        return 0.0;
    }
}
