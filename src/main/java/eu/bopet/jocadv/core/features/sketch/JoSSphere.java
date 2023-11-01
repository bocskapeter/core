package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.features.JoBaseFeature;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import org.apache.commons.math3.geometry.euclidean.threed.Line;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class JoSSphere extends JoBaseFeature implements SketchGeometry, Selectable {
    private final JoPoint center;
    private final JoSValue radius;

    public JoSSphere(JoPoint center, JoSValue radius) {
        this.center = center;
        this.radius = radius;
    }

    public JoPoint getCenter() {
        return center;
    }

    public Vector3D getCenter3D() {
        return center.getVector3D();
    }

    public JoSValue getRadius() {
        return radius;
    }

    public double getRadiusD() {
        return radius.get();
    }

    @Override
    public boolean isOn(JoPoint point) {
        double distance = center.getVector3D().distance(point.getVector3D());
        double difference = Math.abs(distance - radius.get());
        return difference < getTolerance();
    }

    @Override
    public double distance(Line pickingLine) {
        return pickingLine.distance(center.getVector().getVector3D()) - radius.get();
    }

    @Override
    public Set<JoSValue> getValues() {
        Set<JoSValue> result = new LinkedHashSet<>(center.getValues());
        result.add(radius);
        return result;
    }

    @Override
    public Set<JoPoint> getPoints() {
        Set<JoPoint> result = new LinkedHashSet<>();
        result.add(center);
        return result;
    }

    @Override
    public List<JoPoint> getIntersection(SketchGeometry geometry) {
        return null;
    }

    @Override
    public String toString() {
        String name = "⦿";
        if (this.getName() != null) name = this.getName();
        return name + "{" + "☉" + center + "R" + radius + '}';
    }
}
