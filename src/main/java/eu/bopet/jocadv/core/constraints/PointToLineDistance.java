package eu.bopet.jocadv.core.constraints;

import eu.bopet.jocadv.core.features.datums.JoPoint;
import eu.bopet.jocadv.core.features.datums.vector.JoValue;
import eu.bopet.jocadv.core.features.sketch.JoLine;

import java.util.ArrayList;
import java.util.List;

public class PointToLineDistance implements Constraint {
    private final JoLine line;
    private final JoPoint point;
    private final JoValue distance;

    public PointToLineDistance(JoLine line, JoPoint point, JoValue distance) {
        this.line = line;
        this.point = point;
        this.distance = distance;
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
