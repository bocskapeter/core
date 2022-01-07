package eu.bopet.jocadv.core.constraints.sketch;

import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.sketch.JoLine;
import eu.bopet.jocadv.core.features.vector.JoValue;

import java.util.ArrayList;
import java.util.List;

public class PointToLineDistance extends ConstraintBase implements SketchConstraint {
    private final JoLine line;
    private final JoPoint point;
    private final JoValue distance;

    public PointToLineDistance(JoLine line, JoPoint point, JoValue distance, short status) {
        super(status);
        this.line = line;
        this.point = point;
        this.distance = distance;
    }

    @Override
    public List<Object> getComponents() {
        List<Object> result = new ArrayList<>();
        result.add(line);
        result.add(point);
        result.add(distance);
        return result;
    }

    @Override
    public List<JoValue> getValues() {
        List<JoValue> result = new ArrayList<>();
        result.addAll(line.getValues());
        result.addAll(point.getValues());
        result.add(distance);
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
        double x3 = point.getVector().getX().get();
        double y3 = point.getVector().getY().get();
        double z3 = point.getVector().getZ().get();
        // x2-x1
        double a1 = (x2 - x1);
        double a2 = (y2 - y1);
        double a3 = (z2 - z1);
        // x1-x0
        double b1 = (x1 - x3);
        double b2 = (y1 - y3);
        double b3 = (z1 - z3);
        // cross product
        double c1 = (a2 * b3 - a3 * b2);
        double c2 = (a3 * b1 - a1 * b3);
        double c3 = (a1 * b2 - a2 * b1);
        // cross product length
        double nominator = Math.sqrt(c1 * c1 + c2 * c2 + c3 * c3);
        // denominator
        double denominator = Math.sqrt(a1 * a1 + a2 * a2 + a3 * a3);
        return (nominator / denominator) - distance.get();
    }

    @Override
    public double getDerivative(JoValue joValue) {
        double x1 = line.get1stPoint().getVector().getX().get();
        double y1 = line.get1stPoint().getVector().getY().get();
        double z1 = line.get1stPoint().getVector().getZ().get();
        double x2 = line.get2ndPoint().getVector().getX().get();
        double y2 = line.get2ndPoint().getVector().getY().get();
        double z2 = line.get2ndPoint().getVector().getZ().get();
        double x3 = point.getVector().getX().get();
        double y3 = point.getVector().getY().get();
        double z3 = point.getVector().getZ().get();
        // x2-x1
        double a1 = (x2 - x1);
        double a2 = (y2 - y1);
        double a3 = (z2 - z1);
        // x1-x0
        double b1 = (x1 - x3);
        double b2 = (y1 - y3);
        double b3 = (z1 - z3);
        // cross product
        double c1 = (a2 * b3 - a3 * b2);
        double c2 = (a3 * b1 - a1 * b3);
        double c3 = (a1 * b2 - a2 * b1);

        // ∂/∂x1
        // d/dx(
        // (sqrt(c1 +
        // (a3 * (x - x3) - (x2 - x) * b3)^2+
        // ((x2 - x) * b2 - a2 * (x - x3))^2)) /
        // sqrt((x2 - x)^2 + a2^2 + a3^2)
        // )
        // d/dx((sqrt(c1+(a3*(x-x3)-(x2-x)*b3)^2+((x2-x)*b2-a2*(x-x3))^2))/sqrt((x2-x)^2+a2^2+a3^2))
        // d/dx(sqrt(c1 + (a3 (x - x3) - (x2 - x) b3)^2 + ((x2 - x) b2 - a2 (x - x3))^2)/sqrt((x2 - x)^2 + a2^2 + a3^2)) =
        // ((x2 - x) sqrt((b2 (x2 - x) - a2 (x - x3))^2 + (a3 (x - x3) - b3 (x2 - x))^2 + c1))/(a2^2 + a3^2 + (x2 - x)^2)^(3/2) + (2 (-a2 - b2) (b2 (x2 - x) - a2 (x - x3)) + 2 (a3 + b3) (a3 (x - x3) - b3 (x2 - x)))/(2 sqrt(a2^2 + a3^2 + (x2 - x)^2) sqrt((b2 (x2 - x) - a2 (x - x3))^2 + (a3 (x - x3) - b3 (x2 - x))^2 + c1))
        // (    a1   sqrt((b2 (   a1 ) - a2 (  b1  ))^2 + (a3 (  b1  ) - b3 (   a1 ))^2 + c1))/(a2^2 + a3^2 + (   a1 )^2)^(3/2) + (2 (-a2 - b2) (b2 (  a1  ) - a2 (  b1  )) + 2 (a3 + b3) (a3 (  b1  ) - b3 (   a1 )))/(2 sqrt(a2^2 + a3^2 + (   a1 )^2) sqrt((b2 (   a1 ) - a2 (  b1  ))^2 + (a3 (  b1  ) - b3 (   a1 ))^2 + c1))
        // (    a1   sqrt((            c3           )^2 + (            c2           )^2 + c1))/(a2^2 + a3^2 + (   a1 )^2)^(3/2) + (2 (-a2 - b2) (            c3           ) + 2 (a3 + b3) (            c2           ))/(2 sqrt(a2^2 + a3^2 + (   a1 )^2) sqrt((            c3           )^2 + (            c2           )^2 + c1))
        //
        // (a1sqrt((c3)^2+(c2)^2+c1))/(a2^2+a3^2+(a1)^2)^(3/2) + (2(-a2-b2)(c3)+2(a3+b3)(c2)) / (2sqrt(a2^2+a3^2+(a1)^2)sqrt((c3)^2+(c2)^2+c1))
        if (joValue == line.get1stPoint().getVector().getX()) {
            double sqrt = Math.sqrt(c3 * c3 + c2 * c2 + c1);
            double v = a2 * a2 + a3 * a3 + a1 * a1;
            double result = (a1 * sqrt) / Math.pow(v, 3.0 / 2.0) +
                    (2 * (-a2 - b2) * c3 + 2 * (a3 + b3) * c2) / (2 * Math.sqrt(v) * sqrt);
            return result;
        }
        return SketchConstraint.super.getDerivative(joValue);
    }

    @Override
    public String toString() {
        return "⇤D⇥{" + line + ", D=" + distance + ", " + point + '}';
    }
}
