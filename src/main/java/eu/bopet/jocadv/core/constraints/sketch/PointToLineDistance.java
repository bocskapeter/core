package eu.bopet.jocadv.core.constraints.sketch;

import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.sketch.JoLine;

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
        double sqrt = Math.sqrt(c3 * c3 + c2 * c2 + c1 * c1);
        double v = a2 * a2 + a3 * a3 + a1 * a1;
        double result;

        // ∂/∂x1
        // d/dx(
        // (sqrt(c1 +
        // (a3 * (x - x3) - (x2 - x) * b3)^2+
        // ((x2 - x) * b2 - a2 * (x - x3))^2)) /
        // sqrt((x2 - x)^2 + a2^2 + a3^2)
        // )
        // d/dx((sqrt(c1+(a3*(x-x3)-(x2-x)*b3)^2+((x2-x)*b2-a2*(x-x3))^2))/sqrt((x2-x)^2+a2^2+a3^2)) =
        // d/dx(sqrt(c1 + (a3 (x - x3) - (x2 - x) b3)^2 + ((x2 - x) b2 - a2 (x - x3))^2)/sqrt((x2 - x)^2 + a2^2 + a3^2)) =
        // ((x2 - x) sqrt((b2 (x2 - x) - a2 (x - x3))^2 + (a3 (x - x3) - b3 (x2 - x))^2 + c1))/(a2^2 + a3^2 + (x2 - x)^2)^(3/2) + (2 (-a2 - b2) (b2 (x2 - x) - a2 (x - x3)) + 2 (a3 + b3) (a3 (x - x3) - b3 (x2 - x)))/(2 sqrt(a2^2 + a3^2 + (x2 - x)^2) sqrt((b2 (x2 - x) - a2 (x - x3))^2 + (a3 (x - x3) - b3 (x2 - x))^2 + c1))
        // (    a1   sqrt((b2 (   a1 ) - a2 (  b1  ))^2 + (a3 (  b1  ) - b3 (   a1 ))^2 + c1))/(a2^2 + a3^2 + (   a1 )^2)^(3/2) + (2 (-a2 - b2) (b2 (  a1  ) - a2 (  b1  )) + 2 (a3 + b3) (a3 (  b1  ) - b3 (   a1 )))/(2 sqrt(a2^2 + a3^2 + (   a1 )^2) sqrt((b2 (   a1 ) - a2 (  b1  ))^2 + (a3 (  b1  ) - b3 (   a1 ))^2 + c1))
        // (    a1   sqrt((            c3           )^2 + (            c2           )^2 + c1))/(a2^2 + a3^2 + (   a1 )^2)^(3/2) + (2 (-a2 - b2) (            c3           ) + 2 (a3 + b3) (            c2           ))/(2 sqrt(a2^2 + a3^2 + (   a1 )^2) sqrt((            c3           )^2 + (            c2           )^2 + c1))
        //
        // (a1sqrt((c3)^2+(c2)^2+c1)) / (a2^2+a3^2+(a1)^2)^(3/2) + (2(-a2-b2)(c3)+2(a3+b3)(c2)) / (2sqrt(a2^2+a3^2+(a1)^2)sqrt((c3)^2+(c2)^2+c1))
        // (a1 sqrt(c3^2 + c2^2 + c1^2))/(a2^2 + a3^2 + a1^2)^(3/2) + (2 (-a2 - b2) c3 + 2 (a3 + b3) c2)/(2 sqrt(a2^2 + a3^2 + a1^2) sqrt(c3^2 + c2^2 + c1^2))
        if (joValue == line.get1stPoint().getVector().getX()) {
            result = (a1 * sqrt) / Math.pow(v, 1.5) +
                    (2.0 * (-a2 - b2) * c3 + 2.0 * (a3 + b3) * c2) / (2.0 * Math.sqrt(v) * sqrt);
            return result;
        }

        // ∂/∂y1
        // d/dy(
        // sqrt(((y2-y)*b3-a3*(y-y3))^2+c2*c2+(a1*(y-y3)-(y2-y)*b1)^2)
        // /
        // sqrt(a1^2+(y2-y)^2+a3^2)
        // )
        // ((y2 - y) sqrt((a1 (y - y3) - b1 (y2 - y))^2 + (b3 (y2 - y) - a3 (y - y3))^2 + c2^2))/(a1^2 + a3^2 + (y2 - y)^2)^(3/2) + (2 (a1 + b1) (a1 (y - y3) - b1 (y2 - y)) + 2 (-a3 - b3) (b3 (y2 - y) - a3 (y - y3)))/(2 sqrt(a1^2 + a3^2 + (y2 - y)^2) sqrt((a1 (y - y3) - b1 (y2 - y))^2 + (b3 (y2 - y) - a3 (y - y3))^2 + c2^2))
        // (    a2   sqrt((a1    b2    - b1     a2  )^2 + (b3     a2   - a3    b2   )^2 + c2^2))/(a1^2 + a3^2 +     a2  ^2)^(3/2) + (2 (a1 + b1) (a1    b2    - b1     a2  ) + 2 (-a3 - b3) (b3     a2   - a3    b2   ))/(2 sqrt(a1^2 + a3^2 +     a2  ^2) sqrt((a1    b2    - b1     a2  )^2 + (b3     a2   - a3    b2   )^2 + c2^2))
        // (    a2   sqrt(             c3^2             +              c1^2             + c2^2))/(a1^2 + a3^2 +     a2  ^2)^(3/2) + (2 (a1 + b1)              c3             + 2 (-a3 - b3)               c1           )/(2 sqrt(a1^2 + a3^2 +     a2  ^2) sqrt(             c3^2             +              c1^2             + c2^2))
        // (a2sqrt(c3^2+c1^2+c2^2)) / (a1^2+a3^2+a2^2)^(3/2) + (2(a1+b1)c3+2(-a3-b3)c1) / (2sqrt(a1^2+a3^2+a2^2)sqrt(c3^2+c1^2+c2^2))
        if (joValue == line.get1stPoint().getVector().getY()) {
            result = (a2 * sqrt) / Math.pow(v, 1.5) +
                    (2.0 * (a1 + b1) * c3 + 2.0 * (-a3 - b3) * c1) / (2.0 * Math.sqrt(v) * sqrt);
            return result;
        }

        // ∂/∂z1
        // d/dz1
        // d/dz1( sqrt((a2 * b3 - a3 * b2)^2 + (a3 * b1 - a1 * b3)^2 + c3 * c3) / sqrt(a1 * a1 + a2 * a2 + (z2 - z1)^2) )
        // d/dz1( sqrt((a2 * (z1 - z3) - (z2 - z1) * b2)^2 + ((z2 - z1) * b1 - a1 * (z1 - z3))^2 + c3 * c3) / sqrt(a1 * a1 + a2 * a2 + (z2 - z1)^2) )
        // d/dz( sqrt((a2 * (z - z3) - (z2 - z) * b2)^2 + ((z2 - z) * b1 - a1 * (z - z3))^2 + c3 * c3) / sqrt(a1 * a1 + a2 * a2 + (z2 - z)^2) )
        // d/dz(sqrt((a2*(z-z3)-(z2-z)*b2)^2+((z2-z)*b1-a1*(z-z3))^2+c3*c3)/sqrt(a1*a1+a2*a2+(z2-z)^2))
        // d/dz(sqrt((a2 (z - z3) - (z2 - z) b2)^2 + ((z2 - z) b1 - a1 (z - z3))^2 + c3 c3)/sqrt(a1 a1 + a2 a2 + (z2 - z)^2)) =
        // ((z2 - z1) sqrt((b1 (z2 - z1) - a1 (z1 - z3))^2 + (a2 (z1 - z3) - b2 (z2 - z1))^2 + c3^2))/(a1^2 + a2^2 + (z2 - z1)^2)^(3/2) + (2 (-a1 - b1) (b1 (z2 - z1) - a1 (z1 - z3)) + 2 (a2 + b2) (a2 (z1 - z3) - b2 (z2 - z1)))/(2 sqrt(a1^2 + a2^2 + (z2 - z1)^2) sqrt((b1 (z2 - z1) - a1 (z1 - z3))^2 + (a2 (z1 - z3) - b2 (z2 - z1))^2 + c3^2))
        // (a3 sqrt((b1 a3 - a1 (z1 - z3))^2 + (a2 (z1 - z3) - b2 a3)^2 + c3^2))/(a1^2 + a2^2 + a3^2)^(3/2) + (2 (-a1 - b1) (b1 a3 - a1 (z1 - z3)) + 2 (a2 + b2) (a2 (z1 - z3) - b2 a3))/(2 sqrt(a1^2 + a2^2 + a3^2) sqrt((b1 a3 - a1 (z1 - z3))^2 + (a2 (z1 - z3) - b2 a3)^2 + c3^2))
        // (a3 sqrt((b1 a3 - a1 b3)^2 + (a2 b3 - b2 a3)^2 + c3^2))/(a1^2 + a2^2 + a3^2)^(3/2) + (2 (-a1 - b1) (b1 a3 - a1 b3) + 2 (a2 + b2) (a2 b3 - b2 a3))/(2 sqrt(a1^2 + a2^2 + a3^2) sqrt((b1 a3 - a1 b3)^2 + (a2 b3 - b2 a3)^2 + c3^2))
        //(a3 sqrt(c2^2 + c1^2 + c3^2))/(a1^2 + a2^2 + a3^2)^(3/2) + (2 (-a1 - b1) c2 + 2 (a2 + b2) c1)/(2 sqrt(a1^2 + a2^2 + a3^2) sqrt(c2^2 + c1^2 + c3^2))
        if (joValue == line.get1stPoint().getVector().getZ()) {
            result = (a3 * sqrt) / Math.pow(v, 1.5) +
                    (2.0 * (-a1 - b1) * c2 + 2.0 * (a2 + b2) * c1) / (2.0 * Math.sqrt(v) * sqrt);
            return result;
        }

        // ∂/∂x2
        // d/dx2
        // d/dx2 ( sqrt(c1^2 + c2^2 + c3^2) / sqrt(a1^2 + a2^2 + a3^2) )
        // d/dx2 ( sqrt(c1^2 + (a3 * b1 - (x2 - x1) * b3)^2 + ((x2 - x1) * b2 - a2 * b1)^2) / sqrt((x2 - x1)^2 + a2^2 + a3^2) )
        // d/dx ( sqrt(c1^2 + (a3 * b1 - (x - x1) * b3)^2 + ((x - x1) * b2 - a2 * b1)^2) / sqrt((x - x1)^2 + a2^2 + a3^2) )
        // d/dx(sqrt(c1^2+(a3*b1-(x-x1)*b3)^2+((x-x1)*b2-a2*b1)^2)/sqrt((x-x1)^2+a2^2+a3^2))
        // (2 b2 (b2 (x - x1) - a2 b1) - 2 b3 (a3 b1 - b3 (x - x1)))/(2 sqrt(a2^2 + a3^2 + (x - x1)^2) sqrt((b2 (x - x1) - a2 b1)^2 + (a3 b1 - b3 (x - x1))^2 + c1^2)) - ((x - x1) sqrt((b2 (x - x1) - a2 b1)^2 + (a3 b1 - b3 (x - x1))^2 + c1^2))/(a2^2 + a3^2 + (x - x1)^2)^(3/2)
        // (2 b2 (b2 (x2 - x1) - a2 b1) - 2 b3 (a3 b1 - b3 (x2 - x1)))/(2 sqrt(a2^2 + a3^2 + (x2 - x1)^2) sqrt((b2 (x2 - x1) - a2 b1)^2 + (a3 b1 - b3 (x2 - x1))^2 + c1^2)) - ((x2 - x1) sqrt((b2 (x2 - x1) - a2 b1)^2 + (a3 b1 - b3 (x2 - x1))^2 + c1^2))/(a2^2 + a3^2 + (x2 - x1)^2)^(3/2)
        // (2 b2 (b2 a1 - a2 b1) - 2 b3 (a3 b1 - b3 a1))/(2 sqrt(a2^2 + a3^2 + a1^2) sqrt((b2 a1 - a2 b1)^2 + (a3 b1 - b3 a1)^2 + c1^2)) - (a1 sqrt((b2 a1 - a2 b1)^2 + (a3 b1 - b3 a1)^2 + c1^2))/(a2^2 + a3^2 + a1^2)^(3/2)
        // (2 b2 c3 - 2 b3 c2)/(2 sqrt(a2^2 + a3^2 + a1^2) sqrt(c3^2 + c2^2 + c1^2)) - (a1 sqrt(c3^2 + c2^2 + c1^2))/(a2^2 + a3^2 + a1^2)^(3/2)

        if (joValue == line.get2ndPoint().getVector().getX()) {
            result = (2.0 * b2 * b3 - 2.0 * b3 * c2) / (2.0 * Math.sqrt(v) * sqrt) -
                    (a1 * sqrt) / Math.pow(v, 1.5);
            return result;
        }

        // ∂/∂y2
        // d/dy2
        // d/dy2 (sqrt(((y2 - y1) * b3 - a3 * b2)^2 + c2^2 + (a1 * b2 - (y2 - y1) * b1)^2) / sqrt(a1^2 + (y2 - y1)^2 + a3^2))
        // d/dy (sqrt(((y - y1) * b3 - a3 * b2)^2 + c2^2 + (a1 * b2 - (y - y1) * b1)^2) / sqrt(a1^2 + (y - y1)^2 + a3^2))
        // d/dy(sqrt(((y-y1)*b3-a3*b2)^2+c2^2+(a1*b2-(y-y1)*b1)^2)/sqrt(a1^2+(y-y1)^2+a3^2))
        // d/dy(sqrt(((y - y1) b3 - a3 b2)^2 + c2^2 + (a1 b2 - (y - y1) b1)^2)/sqrt(a1^2 + (y - y1)^2 + a3^2))
        // (2 b3 (b3 (y2 - y1) - a3 b2) - 2 b1 (a1 b2 - b1 (y2 - y1)))/(2 sqrt(a1^2 + a3^2 + (y2 - y1)^2) sqrt((a1 b2 - b1 (y2 - y1))^2 + (b3 (y2 - y1) - a3 b2)^2 + c2^2)) - ((y2 - y1) sqrt((a1 b2 - b1 (y2 - y1))^2 + (b3 (y2 - y1) - a3 b2)^2 + c2^2))/(a1^2 + a3^2 + (y2 - y1)^2)^(3/2)
        // (2 b3 c1 - 2 b1 c3)/(2 sqrt(a1^2 + a3^2 + a2^2) sqrt(c3^2 + c1^2 + c2^2)) - (a2 sqrt(c3^2 + c1^2 + c2^2))/(a1^2 + a3^2 + a2^2)^(3/2)

        if (joValue == line.get2ndPoint().getVector().getY()) {
            result = (2.0 * b3 * c1 - 2.0 * b1 * c3) / (2.0 * Math.sqrt(v) * sqrt) -
                    (a2 * sqrt) / Math.pow(v, 1.5);
            return result;
        }

        // ∂/∂z2
        // d/dz2
        // d/dz2( (sqrt((a2 * b3 - a3 * b2)^2 + (a3 * b1 - a1 * b3)^2 + c3^2) / sqrt(a1^2 + a2^2 + a3^2)) )
        // d/dz2( (sqrt((a2 * b3 - (z2 - z1) * b2)^2 + ((z2 - z1) * b1 - a1 * b3)^2 + c3^2) / sqrt(a1^2 + a2^2 + (z2 - z1)^2)) )
        // d/dz( (sqrt((a2 * b3 - (z - z1) * b2)^2 + ((z - z1) * b1 - a1 * b3)^2 + c3^2) / sqrt(a1^2 + a2^2 + (z - z1)^2)) )
        // d/dz((sqrt((a2*b3-(z-z1)*b2)^2+((z-z1)*b1-a1*b3)^2+c3^2)/sqrt(a1^2+a2^2+(z-z1)^2)))
        // d/dz(sqrt((a2 b3 - (z - z1) b2)^2 + ((z - z1) b1 - a1 b3)^2 + c3^2)/sqrt(a1^2 + a2^2 + (z - z1)^2))
        // (2 b1 (b1 (z - z1) - a1 b3) - 2 b2 (a2 b3 - b2 (z - z1)))/(2 sqrt(a1^2 + a2^2 + (z - z1)^2) sqrt((b1 (z - z1) - a1 b3)^2 + (a2 b3 - b2 (z - z1))^2 + c3^2)) - ((z - z1) sqrt((b1 (z - z1) - a1 b3)^2 + (a2 b3 - b2 (z - z1))^2 + c3^2))/(a1^2 + a2^2 + (z - z1)^2)^(3/2)
        // (2 b1 (b1 (z2 - z1) - a1 b3) - 2 b2 (a2 b3 - b2 (z2 - z1)))/(2 sqrt(a1^2 + a2^2 + (z2 - z1)^2) sqrt((b1 (z2 - z1) - a1 b3)^2 + (a2 b3 - b2 (z2 - z1))^2 + c3^2)) - ((z2 - z1) sqrt((b1 (z2 - z1) - a1 b3)^2 + (a2 b3 - b2 (z2 - z1))^2 + c3^2))/(a1^2 + a2^2 + (z2 - z1)^2)^(3/2)
        // (2 b1 (b1 a3 - a1 b3) - 2 b2 (a2 b3 - b2 a3))/(2 sqrt(a1^2 + a2^2 + a3^2) sqrt((b1 a3 - a1 b3)^2 + (a2 b3 - b2 a3)^2 + c3^2)) - (a3 sqrt((b1 a3 - a1 b3)^2 + (a2 b3 - b2 a3)^2 + c3^2))/(a1^2 + a2^2 + a3^2)^(3/2)
        // (2 b1 c2 - 2 b2 c1)/(2 sqrt(a1^2 + a2^2 + a3^2) sqrt(c2^2 + c1^2 + c3^2)) - (a3 sqrt(c2^2 + c1^2 + c3^2))/(a1^2 + a2^2 + a3^2)^(3/2)
        // (2b1c2-2b2c1)/(2sqrt(a1^2+a2^2+a3^2)sqrt(c2^2+c1^2+c3^2))-(a3sqrt(c2^2+c1^2+c3^2))/(a1^2+a2^2+a3^2)^(3/2)

        if (joValue == line.get2ndPoint().getVector().getZ()) {
            result = (2.0 * b1 * c2 - 2.0 * b2 * c1) / (2.0 * Math.sqrt(v) * sqrt) -
                    (a3 * sqrt) / Math.pow(v, 1.5);
            return result;
        }

        // ∂/∂x3
        // d/dx3
        // d/dx3(sqrt(c1^2 + c2^2 + c3^2) / sqrt(a1^2 + a2^2 + a3^2))
        // d/dx3( sqrt(c1^2 + (a3 * b1 - a1 * b3)^2 + (a1 * b2 - a2 * b1)^2) / sqrt(a1^2 + a2^2 + a3^2) )
        // d/dx3( sqrt(c1^2 + (a3 * (x1 - x3) - a1 * b3)^2 + (a1 * b2 - a2 * (x1 - x3))^2) / sqrt(a1^2 + a2^2 + a3^2) )
        // d/dx(sqrt(c1^2+(a3*(x1-x)-a1*b3)^2+(a1*b2-a2*(x1-x))^2)/sqrt(a1^2+a2^2+a3^2))
        // d/dx(sqrt(c1^2 + (a3 (x1 - x) - a1 b3)^2 + (a1 b2 - a2 (x1 - x))^2)/sqrt(a1^2 + a2^2 + a3^2))
        // (2 a2 (a1 b2 - a2 (x1 - x)) - 2 a3 (a3 (x1 - x) - a1 b3))/(2 sqrt(a1^2 + a2^2 + a3^2) sqrt((a1 b2 - a2 (x1 - x))^2 + (a3 (x1 - x) - a1 b3)^2 + c1^2))
        // (2 a2 (a1 b2 - a2 (x1 - x3)) - 2 a3 (a3 (x1 - x3) - a1 b3))/(2 sqrt(a1^2 + a2^2 + a3^2) sqrt((a1 b2 - a2 (x1 - x3))^2 + (a3 (x1 - x3) - a1 b3)^2 + c1^2))
        // (2 a2 (a1 b2 - a2 b1) - 2 a3 (a3 b1 - a1 b3))/(2 sqrt(a1^2 + a2^2 + a3^2) sqrt((a1 b2 - a2 b1)^2 + (a3 b1 - a1 b3)^2 + c1^2))
        // (2 a2 c3 - 2 a3 c2)/(2 sqrt(a1^2 + a2^2 + a3^2) sqrt(c3^2 + c2^2 + c1^2))
        if (joValue == point.getVector().getX()) {
            result = (2.0 * a2 * c3 - 2.0 * a3 * c2) / (2.0 * Math.sqrt(v) * sqrt);
            return result;
        }

        // ∂/∂y3
        // d/dy3
        // d/dy3( sqrt(c1^2 + c2^2 + c3^2) / sqrt(a1^2 + a2^2 + a3^2) )
        // d/dy3( sqrt((a2 * b3 - a3 * b2)^2 + c2^2 + (a1 * b2 - a2 * b1)^2) / sqrt(a1^2 + a2^2 + a3^2) )
        // d/dy3( sqrt((a2 * b3 - a3 * (y1 - y3))^2 + c2^2 + (a1 * (y1 - y3) - a2 * b1)^2) / sqrt(a1^2 + a2^2 + a3^2) )
        // d/dy( sqrt((a2 * b3 - a3 * (y1 - y))^2 + c2^2 + (a1 * (y1 - y) - a2 * b1)^2) / sqrt(a1^2 + a2^2 + a3^2) )
        // d/dy(sqrt((a2*b3-a3*(y1-y))^2+c2^2+(a1*(y1-y)-a2*b1)^2)/sqrt(a1^2+a2^2+a3^2))
        // d/dy(sqrt((a2 b3 - a3 (y1 - y))^2 + c2^2 + (a1 (y1 - y) - a2 b1)^2)/sqrt(a1^2 + a2^2 + a3^2))
        // (2 a3 (a2 b3 - a3 (y1 - y3)) - 2 a1 (a1 (y1 - y3) - a2 b1))/(2 sqrt(a1^2 + a2^2 + a3^2) sqrt((a1 (y1 - y3) - a2 b1)^2 + (a2 b3 - a3 (y1 - y3))^2 + c2^2))
        // (2 a3 (a2 b3 - a3 b2) - 2 a1 (a1 b2 - a2 b1))/(2 sqrt(a1^2 + a2^2 + a3^2) sqrt((a1 b2 - a2 b1)^2 + (a2 b3 - a3 b2)^2 + c2^2))
        // (2 a3 c1 - 2 a1 c3)/(2 sqrt(a1^2 + a2^2 + a3^2) sqrt(c3^2 + c1^2 + c2^2))
        if (joValue == point.getVector().getY()) {
            result = (2.0 * a3 * c1 - 2.0 * a1 * c3) / (2.0 * Math.sqrt(v) * sqrt);
            return result;
        }

        // ∂/∂z3
        // d/dz3( sqrt(c1^2 + c2^2 + c3^2) / sqrt(a1^2 + a2^2 + a3^2) )
        // d/dz3( sqrt((a2 * b3 - a3 * b2)^2 + (a3 * b1 - a1 * b3)^2 + c3^2) / sqrt(a1^2 + a2^2 + a3^2) )
        // d/dz3( sqrt((a2 * (z1 - z3) - a3 * b2)^2 + (a3 * b1 - a1 * (z1 - z3))^2 + c3^2) / sqrt(a1^2 + a2^2 + a3^2) )
        // d/dz( sqrt((a2 * (z1 - z) - a3 * b2)^2 + (a3 * b1 - a1 * (z1 - z))^2 + c3^2) / sqrt(a1^2 + a2^2 + a3^2) )
        // d/dz(sqrt((a2*(z1-z)-a3*b2)^2+(a3*b1-a1*(z1-z))^2+c3^2)/sqrt(a1^2+a2^2+a3^2))
        // d/dz(sqrt((a2 (z1 - z) - a3 b2)^2 + (a3 b1 - a1 (z1 - z))^2 + c3^2)/sqrt(a1^2 + a2^2 + a3^2))
        // (2 a1 (a3 b1 - a1 (z1 - z)) - 2 a2 (a2 (z1 - z) - a3 b2))/(2 sqrt(a1^2 + a2^2 + a3^2) sqrt((a3 b1 - a1 (z1 - z))^2 + (a2 (z1 - z) - a3 b2)^2 + c3^2))
        // (2 a1 (a3 b1 - a1 (z1 - z3)) - 2 a2 (a2 (z1 - z3) - a3 b2))/(2 sqrt(a1^2 + a2^2 + a3^2) sqrt((a3 b1 - a1 (z1 - z3))^2 + (a2 (z1 - z3) - a3 b2)^2 + c3^2))
        // (2 a1 (a3 b1 - a1 b3) - 2 a2 (a2 b3 - a3 b2))/(2 sqrt(a1^2 + a2^2 + a3^2) sqrt((a3 b1 - a1 b3)^2 + (a2 b3 - a3 b2)^2 + c3^2))
        // (2 a1 c2 - 2 a2 c1)/(2 sqrt(a1^2 + a2^2 + a3^2) sqrt(c2^2 + c1^2 + c3^2))
        if (joValue == point.getVector().getZ()) {
            result = (2.0 * a1 * c2 - 2.0 * a2 * c1) / (2.0 * Math.sqrt(v) * sqrt);
            return result;
        }

        return 0.0;
    }

    @Override
    public String toString() {
        return "⇤D⇥{" + line + ", D=" + distance + ", " + point + '}';
    }
}
