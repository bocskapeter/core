package eu.bopet.jocadv.core.features.datums;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.FeatureBase;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.Set;

public class JoAxis extends FeatureBase implements Selectable, Feature {
    public static final JoAxis X = new JoAxis("X", JoPoint.ORIGIN, JoVector.I, null);
    public static final JoAxis Y = new JoAxis("Y", JoPoint.ORIGIN, JoVector.J, null);
    public static final JoAxis Z = new JoAxis("Z", JoPoint.ORIGIN, JoVector.K, null);
    private final JoPoint point;
    private final JoVector direction;
    private RegenerativeLink regenerativeLink;

    public JoAxis(JoPoint point, JoVector direction, RegenerativeLink regenerativeLink) {
        this.point = point;
        this.direction = direction;
        this.regenerativeLink = regenerativeLink;
    }

    public JoAxis(String name, JoPoint point, JoVector direction, RegenerativeLink regenerativeLink) {
        super();
        super.setName(name);
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

    @Override
    public void setRegenerativeLink(RegenerativeLink newRegenerativeLink) {
        this.regenerativeLink = newRegenerativeLink;
    }

    @Override
    public Set<JoValue> getValues() {
        Set<JoValue> result = Feature.super.getValues();
        result.addAll(point.getValues());
        result.addAll(direction.getValues());
        return result;
    }

    @Override
    public void store() {
        Feature.super.store();
        point.store();
        direction.store();
    }

    @Override
    public String toString() {
        String name = "⤇";
        if (this.getName() != null) name = this.getName();
        return name + "{" + point + ", " + direction + '}';
    }
}
