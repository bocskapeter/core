package eu.bopet.jocadv.core.constraints.sketch;

import eu.bopet.jocadv.core.features.sketch.JoSValue;
import eu.bopet.jocadv.core.features.sketch.JoSLine;

import java.util.ArrayList;
import java.util.List;

public class LineParallelToLine extends ConstraintBase implements SketchConstraint {
    private final JoSLine line1;
    private final JoSLine line2;

    public LineParallelToLine(short status, JoSLine line1, JoSLine line2) {
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
    public List<JoSValue> getValues() {
        List<JoSValue> result = new ArrayList<>();
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

        return (((y2 - y1) * (z4 - z3) - (z2 - z1) * (y4 - y3)) +
                ((z2 - z1) * (x4 - x3) - (x2 - x1) * (z4 - z3)) +
                ((x2 - x1) * (y4 - y3) - (y2 - y1) * (x4 - x3)));
    }

    @Override
    public double getDerivative(JoSValue joSValue) {
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

        //dx1
        if (joSValue == line1.get1stPoint().getVector().getX()) {
            return z4 - z3 - y4 + y3;
        }
        //dy1
        if (joSValue == line1.get1stPoint().getVector().getY()) {
            return -z4 + z3 + x4 - x3;
        }
        //dz1
        if (joSValue == line1.get1stPoint().getVector().getZ()) {
            return y4 - y3 - x4 + x3;
        }
        //dx2
        if (joSValue == line1.get2ndPoint().getVector().getX()) {
            return -z4 + z3 + y4 - y3;
        }
        //dy2
        if (joSValue == line1.get2ndPoint().getVector().getY()) {
            return z4 - z3 - x4 + x3;
        }
        //dz2
        if (joSValue == line1.get2ndPoint().getVector().getZ()) {
            return -y4 + y3 + x4 - x3;
        }
        //dx3
        if (joSValue == line2.get1stPoint().getVector().getX()) {
            return -z2 + z1 + y2 - y1;
        }
        //dy3
        if (joSValue == line2.get1stPoint().getVector().getY()) {
            return -z2 + z1 + x2 - x1;
        }
        //dz3
        if (joSValue == line2.get1stPoint().getVector().getZ()) {
            return y2 - y1 - x2 + x1;
        }
        //dx4
        if (joSValue == line2.get2ndPoint().getVector().getX()) {
            return z2 - z1 + y2 - y1;
        }
        //dy4
        if (joSValue == line2.get2ndPoint().getVector().getY()) {
            return -z2 + z1 + x2 - x1;
        }
        //dz4
        if (joSValue == line2.get2ndPoint().getVector().getZ()) {
            return y2 - y1 - x2 + x1;
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return "∥{" + line1 + " to " + line2 + '}';
    }
}
