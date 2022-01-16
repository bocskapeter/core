package eu.bopet.jocadv.core.constraints.sketch;

import eu.bopet.jocadv.core.features.sketch.JoLine;
import eu.bopet.jocadv.core.features.vector.JoValue;

import java.util.ArrayList;
import java.util.List;

public class LinePerpendicularToLine extends ConstraintBase implements SketchConstraint {
    private final JoLine line1;
    private final JoLine line2;

    public LinePerpendicularToLine(short status, JoLine line1, JoLine line2) {
        super(status);
        this.line1 = line1;
        this.line2 = line2;
    }

    @Override
    public List<Object> getComponents() {
        List<Object> result = new ArrayList<>();
        result.add(line1);
        result.add(line2);
        return result;
    }

    @Override
    public List<JoValue> getValues() {
        List<JoValue> result = new ArrayList<>();
        result.addAll(line1.getValues());
        result.addAll(line2.getValues());
        return result;
    }

    @Override
    public double getFunctionValue() {
        double x1 = line1.get1stPoint().getVector().getX().get();
        double y1 = line1.get1stPoint().getVector().getY().get();
        double z1 = line1.get1stPoint().getVector().getZ().get();
        double x2 = line1.get2ndPoint().getVector().getX().get();
        double y2 = line1.get2ndPoint().getVector().getY().get();
        double z2 = line1.get2ndPoint().getVector().getZ().get();
        double x3 = line2.get1stPoint().getVector().getX().get();
        double y3 = line2.get1stPoint().getVector().getY().get();
        double z3 = line2.get1stPoint().getVector().getZ().get();
        double x4 = line2.get2ndPoint().getVector().getX().get();
        double y4 = line2.get2ndPoint().getVector().getY().get();
        double z4 = line2.get2ndPoint().getVector().getZ().get();
        double a1 = (x2 - x1);
        double a2 = (y2 - y1);
        double a3 = (z2 - z1);
        double b1 = (x4 - x3);
        double b2 = (y4 - y3);
        double b3 = (z4 - z3);
        return a1 * b1 + a2 * b2 + a3 * b3;
    }

    @Override
    public double getDerivative(JoValue joValue) {
        double x1 = line1.get1stPoint().getVector().getX().get();
        double y1 = line1.get1stPoint().getVector().getY().get();
        double z1 = line1.get1stPoint().getVector().getZ().get();
        double x2 = line1.get2ndPoint().getVector().getX().get();
        double y2 = line1.get2ndPoint().getVector().getY().get();
        double z2 = line1.get2ndPoint().getVector().getZ().get();
        double x3 = line2.get1stPoint().getVector().getX().get();
        double y3 = line2.get1stPoint().getVector().getY().get();
        double z3 = line2.get1stPoint().getVector().getZ().get();
        double x4 = line2.get2ndPoint().getVector().getX().get();
        double y4 = line2.get2ndPoint().getVector().getY().get();
        double z4 = line2.get2ndPoint().getVector().getZ().get();
        double a1 = (x2 - x1);
        double a2 = (y2 - y1);
        double a3 = (z2 - z1);
        double b1 = (x4 - x3);
        double b2 = (y4 - y3);
        double b3 = (z4 - z3);
        // a1 * b1 + a2 * b2 + a3 * b3

        // x1
        if (joValue == line1.get1stPoint().getVector().getX()) {
            return -1.0 * b1;
        }
        // y1
        if (joValue == line1.get1stPoint().getVector().getY()) {
            return -1.0 * b2;
        }
        // z1
        if (joValue == line1.get1stPoint().getVector().getZ()) {
            return -1.0 * b3;
        }
        // x2
        if (joValue == line1.get2ndPoint().getVector().getX()) {
            return b1;
        }
        // y2
        if (joValue == line1.get2ndPoint().getVector().getY()) {
            return b2;
        }
        // z2
        if (joValue == line1.get2ndPoint().getVector().getZ()) {
            return b3;
        }
        // x3
        if (joValue == line2.get1stPoint().getVector().getX()) {
            return -1.0 * a1;
        }
        // y3
        if (joValue == line2.get1stPoint().getVector().getY()) {
            return -1.0 * a2;
        }
        // z3
        if (joValue == line2.get1stPoint().getVector().getZ()) {
            return -1.0 * a3;
        }
        // x4
        if (joValue == line2.get2ndPoint().getVector().getX()) {
            return a1;
        }
        // y4
        if (joValue == line2.get2ndPoint().getVector().getY()) {
            return a2;
        }
        // z4
        if (joValue == line2.get2ndPoint().getVector().getZ()) {
            return a3;
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return "⟂{" + line1 + " to " + line2 + '}';
    }
}
