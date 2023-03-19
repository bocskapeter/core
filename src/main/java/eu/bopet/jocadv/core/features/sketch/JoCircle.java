package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.features.FeatureBase;
import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import org.apache.commons.math3.geometry.euclidean.threed.Line;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class JoCircle extends FeatureBase implements SketchGeometry, Selectable {
    private final JoSphere sphere;
    private final JoPlane plane;

    public JoCircle(JoSphere sphere, JoPlane plane) {
        this.sphere = sphere;
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
        // TODO calculate intersection with arc, circle and line
        return null;
    }

    @Override
    public String toString() {
        String name = "⨀";
        if (this.getName() != null) name = this.getName();
        return name + "{" + sphere + " ⤓ " + plane + '}';
    }
}
