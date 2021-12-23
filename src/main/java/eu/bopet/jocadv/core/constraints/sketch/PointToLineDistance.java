package eu.bopet.jocadv.core.constraints.sketch;

import eu.bopet.jocadv.core.constraints.ConstraintBase;
import eu.bopet.jocadv.core.constraints.SketchConstraint;
import eu.bopet.jocadv.core.features.Geometry;
import eu.bopet.jocadv.core.features.datums.JoPoint;
import eu.bopet.jocadv.core.features.datums.vector.JoValue;
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
    public List<Geometry> getGeometries() {
        List<Geometry> result = new ArrayList<>();
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
        //TODO
        return 0;
    }

    @Override
    public double getDerivative(JoValue joValue) {
        //TODO
        return 0;
    }
}
