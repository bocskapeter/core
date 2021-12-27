package eu.bopet.jocadv.core.features.datums;

import eu.bopet.jocadv.core.features.Base;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

public class JoAxis extends Base implements Selectable {
    public static final JoAxis X = new JoAxis(JoPoint.ORIGIN, JoVector.I);
    public static final JoAxis Y = new JoAxis(JoPoint.ORIGIN, JoVector.J);
    public static final JoAxis Z = new JoAxis(JoPoint.ORIGIN, JoVector.K);
    private final JoPoint point;
    private final JoVector direction;

    public JoAxis(JoPoint point, JoVector direction) {
        this.point = point;
        this.direction = direction;
    }

    public JoPoint getPoint() {
        return point;
    }

    public JoVector getDirection() {
        return direction;
    }

    public Line getLine(){
        return new Line(
                point.getVector().getVector3D(),
                point.getVector().getVector3D().add(direction.getVector3D()),
                JoValue.DEFAULT_TOLERANCE );
    }

    @Override
    public double distance(Line pickingLine) {
        return getLine().distance(pickingLine);
    }
}
