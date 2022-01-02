package eu.bopet.jocadv.core.constraints.sketch;

import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.sketch.JoLine;
import eu.bopet.jocadv.core.features.sketch.SketchGeometry;
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
    public List<SketchGeometry> getGeometries() {
        List<SketchGeometry> result = new ArrayList<>();
        result.add(line);
        result.add(point);
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

        // cross product length
        double nominator = Math.sqrt(
                ((y2 - y1) * (z1 - z3) - (z2 - z1) * (y1 - y3)) * ((y2 - y1) * (z1 - z3) - (z2 - z1) * (y1 - y3)) +
                ((z2 - z1) * (x1 - x3) - (x2 - x1) * (z1 - z3)) * ((z2 - z1) * (x1 - x3) - (x2 - x1) * (z1 - z3)) +
                ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3)) * ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3)));
        // denominator
        double denominator = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) + (z2 - z1) * (z2 - z1));

        return nominator / denominator;
    }

    @Override
    public double getDerivative(JoValue joValue) {
        //TODO calculate derivative value
        return 0;
    }
}
