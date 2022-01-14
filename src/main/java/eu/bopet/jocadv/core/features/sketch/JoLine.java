package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.features.FeatureBase;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.vector.JoValue;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.LinkedHashSet;
import java.util.Set;

public class JoLine extends FeatureBase implements SketchGeometry, Selectable {
    private final JoPoint point1;
    private final JoPoint point2;

    public JoLine(JoPoint point1, JoPoint point2) {
        this.point1 = point1;
        this.point2 = point2;
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
    public Set<JoValue> getValues() {
        Set<JoValue> result = new LinkedHashSet<>();
        result.addAll(point1.getValues());
        result.addAll(point2.getValues());
        return result;
    }

    @Override
    public Set<JoPoint> getPoints() {
        Set<JoPoint> result = new LinkedHashSet<>();
        result.add(point1);
        result.add(point2);
        return result;
    }

    @Override
    public String toString() {
        String name = "/";
        if (this.getName() != null) name = this.getName();
        return name + "{" + "↦ " + point1 + " ↤ " + point2 + '}';
    }
}
