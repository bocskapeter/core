package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.features.FeatureBase;
import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.sketch.exception.NotValidCircleException;
import org.apache.commons.math3.geometry.euclidean.threed.Line;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class JoCircle extends FeatureBase implements SketchGeometry, Selectable {
    private final JoSphere sphere;
    private final JoPlane plane;

    public JoCircle(JoSphere sphere, JoPlane plane) throws Exception {
        this.sphere = sphere;
        if (!plane.isOn(sphere.getCenter())) {
            throw new NotValidCircleException(sphere, plane);
        }
        this.plane = plane;
    }

    public JoSphere getSphere() {
        return sphere;
    }

    public JoPoint getCenter() {
        return sphere.getCenter();
    }

    public Vector3D getCenter3D() {
        return sphere.getCenter3D();
    }

    public JoValue getRadius() {
        return sphere.getRadius();
    }

    public double getRadiusD() {
        return sphere.getRadiusD();
    }

    public JoPlane getPlane() {
        return plane;
    }

    @Override
    public boolean isOn(JoPoint point) {
        if (sphere.isOn(point)) {
            return plane.isOn(point);
        }
        return false;
    }

    @Override
    public double distance(Line pickingLine) {
        return sphere.distance(pickingLine);
    }

    @Override
    public Set<JoValue> getValues() {
        return new LinkedHashSet<>(sphere.getValues());
    }

    @Override
    public Set<JoPoint> getPoints() {
        return new LinkedHashSet<>(sphere.getPoints());
    }

    @Override
    public List<JoPoint> getIntersection(SketchGeometry geometry) {
        if (geometry instanceof JoLine) {
            JoLine line = (JoLine) geometry;
            return line.getIntersection(this);
        }
        // TODO calculate intersection with arc, circle
        return null;
    }

    @Override
    public String toString() {
        String name = "⨀";
        if (this.getName() != null) name = this.getName();
        return name + "{" + sphere + " ⤓ " + plane + '}';
    }
}
