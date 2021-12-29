package eu.bopet.jocadv.core.features.datums;

import eu.bopet.jocadv.core.constraints.feature.RegenerativeLink;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.FeatureBase;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

public class JoAxis extends FeatureBase implements Selectable, Feature {
    public static final JoAxis X = new JoAxis(JoPoint.ORIGIN, JoVector.I, null);
    public static final JoAxis Y = new JoAxis(JoPoint.ORIGIN, JoVector.J, null);
    public static final JoAxis Z = new JoAxis(JoPoint.ORIGIN, JoVector.K, null);
    private final JoPoint point;
    private final JoVector direction;
    private final RegenerativeLink regenerativeLink;

    public JoAxis(JoPoint point, JoVector direction, RegenerativeLink regenerativeLink) {
        this.point = point;
        this.direction = direction;
        this.regenerativeLink = regenerativeLink;
    }

    public JoPoint getPoint() {
        return point;
    }

    public JoVector getDirection() {
        return direction;
    }

    public Line getLine() {
        return new Line(
                point.getVector().getVector3D(),
                point.getVector().getVector3D().add(direction.getVector3D()),
                JoValue.DEFAULT_TOLERANCE);
    }

    @Override
    public double distance(Line pickingLine) {
        return getLine().distance(pickingLine);
    }

    @Override
    public RegenerativeLink getRegenerativeLink() {
        return regenerativeLink;
    }
}
