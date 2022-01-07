package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.features.FeatureBase;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.vector.JoValue;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.ArrayList;
import java.util.List;

public class JoLine extends FeatureBase implements SketchGeometry, Selectable {
    private final JoPoint point1;
    private final JoPoint point2;
    private boolean constructive;

    public JoLine(JoPoint point1, JoPoint point2) {
        this.point1 = point1;
        this.point2 = point2;
        this.constructive = false;
    }

    public JoPoint get1stPoint() {
        return point1;
    }

    public JoPoint get2ndPoint() {
        return point2;
    }

    @Override
    public double distance(Line pickingLine) {
        return pickingLine.distance(geLine());
    }

    private Line geLine() {
        return new Line(point1.getVector().getVector3D(), point2.getVector().getVector3D(), JoValue.DEFAULT_TOLERANCE);
    }

    @Override
    public List<JoValue> getValues() {
        List<JoValue> result = new ArrayList<>();
        result.addAll(point1.getValues());
        result.addAll(point2.getValues());
        return result;
    }

    @Override
    public List<JoPoint> getPoints() {
        List<JoPoint> result = new ArrayList<>();
        result.add(point1);
        result.add(point2);
        return result;
    }
}
