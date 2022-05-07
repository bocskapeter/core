package eu.bopet.jocadv.core.constraints.sketch;

import eu.bopet.jocadv.core.features.sketch.JoLine;
import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;

import java.util.ArrayList;
import java.util.List;

public class LineParallelToDirection extends ConstraintBase implements SketchConstraint {
    private final JoLine line;
    private final JoVector vector;

    public LineParallelToDirection(short status, JoLine line, JoVector vector) {
        super(status);
        this.line = line;
        this.vector = vector;
    }

    @Override
    public List<Object> getComponents() {
        List<Object> result = new ArrayList<>();
        result.add(line);
        result.add(vector);
        return result;
    }

    @Override
    public List<JoValue> getValues() {
        List<JoValue> result = new ArrayList<>();
        result.addAll(line.getValues());
        result.addAll(vector.getValues());
        return result;
    }

    @Override
    public double getFunctionValue() {
        double x1 = line.get1stPoint().getVector().getX().get();
        double y1 = line.get1stPoint().getVector().getY().get();
        double z1 = line.get1stPoint().getVector().getZ().get();
        double x2 = line.get2ndPoint().getVector().getX().get();
        double y2 = line.get2ndPoint().getVector().getY().get();
        double z2 = line.get2ndPoint().getVector().getZ().get();
        double x3 = vector.getX().get();
        double y3 = vector.getY().get();
        double z3 = vector.getZ().get();
        return ((y2 - y1) * z3 - (z2 - z1) * y3) +
                ((z2 - z1) * x3 - (x2 - x1) * z3) +
                ((x2 - x1) * y3 - (y2 - y1) * x3);
    }

    @Override
    public double getDerivative(JoValue joValue) {
        double x1 = line.get1stPoint().getVector().getX().get();
        double y1 = line.get1stPoint().getVector().getY().get();
        double z1 = line.get1stPoint().getVector().getZ().get();
        double x2 = line.get2ndPoint().getVector().getX().get();
        double y2 = line.get2ndPoint().getVector().getY().get();
        double z2 = line.get2ndPoint().getVector().getZ().get();
        double x3 = vector.getX().get();
        double y3 = vector.getY().get();
        double z3 = vector.getZ().get();
        if (joValue == line.get1stPoint().getVector().getX()) {
            return z3 - y3;
        }
        if (joValue == line.get1stPoint().getVector().getY()) {
            return -z3 + x3;
        }
        if (joValue == line.get1stPoint().getVector().getZ()) {
            return y3 - x3;
        }
        if (joValue == line.get2ndPoint().getVector().getX()) {
            return -z3 + y3;
        }
        if (joValue == line.get2ndPoint().getVector().getY()) {
            return z3 - x3;
        }
        if (joValue == line.get2ndPoint().getVector().getZ()) {
            return -y3 + x3;
        }
        if (joValue == vector.getX()) {
            return z2 - z1 - y2 + y1;
        }
        if (joValue == vector.getY()) {
            return -z2 + z1 + x2 - x1;
        }
        if (joValue == vector.getZ()) {
            return y2 - y1 - x2 + x1;
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return "∥{" + line + " to " + vector + '}';
    }
}
