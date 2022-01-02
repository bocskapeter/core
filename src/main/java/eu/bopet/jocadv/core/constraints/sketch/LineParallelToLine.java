package eu.bopet.jocadv.core.constraints.sketch;

import eu.bopet.jocadv.core.features.sketch.JoLine;
import eu.bopet.jocadv.core.features.sketch.SketchGeometry;
import eu.bopet.jocadv.core.features.vector.JoValue;

import java.util.ArrayList;
import java.util.List;

public class LineParallelToLine extends ConstraintBase implements SketchConstraint{
    private final JoLine line1;
    private final JoLine line2;

    public LineParallelToLine(short status, JoLine line1, JoLine line2) {
        super(status);
        this.line1 = line1;
        this.line2 = line2;
    }

    @Override
    public List<SketchGeometry> getGeometries() {
        List<SketchGeometry> result = new ArrayList<>();
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
        //TODO calculate function value
        return 0;
    }

    @Override
    public double getDerivative(JoValue joValue) {
        //TODO calculate derivative value
        return 0;
    }
}
