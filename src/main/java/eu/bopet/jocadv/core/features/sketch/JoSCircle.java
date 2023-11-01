package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.features.JoBaseFeature;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.sketch.exception.NotValidCircleException;
import org.apache.commons.math3.geometry.euclidean.threed.Line;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class JoSCircle extends JoBaseFeature implements SketchGeometry, Selectable {
    private final JoSSphere sphere;
    private final JoPlane plane;

    public JoSCircle(JoSSphere sphere, JoPlane plane) throws Exception {
        this.sphere = sphere;
        if (!plane.isOn(sphere.getCenter())) {
            double distance = Math.abs(plane.getPlane().getOffset(sphere.getCenter3D()));
            double exp = (Math.log10(JoSValue.DEFAULT_TOLERANCE) / 2.0);
            double tolerance = Math.pow(10.0, exp);
            System.out.println("---");
            System.out.println("Center point of the circle is not on the plane in the default tolerance!");
            System.out.println("Center point: " + sphere.getCenter());
            System.out.println("Plane: " + plane);
            System.out.println("Distance: " + distance);
            System.out.println("Default tolerance: " + JoSValue.DEFAULT_TOLERANCE);
            System.out.println("New tolerance: " + tolerance);
            if (distance > tolerance) {
                System.out.println("Circle is not on the plane in the new tolerance!");
                throw new NotValidCircleException(sphere, plane);
            } else {
                System.out.println("Custom tolerance should be considered!");
            }
            System.out.println("---");
        }
        this.plane = plane;
    }

    public JoSSphere getSphere() {
        return sphere;
    }

    public JoPoint getCenter() {
        return sphere.getCenter();
    }

    public Vector3D getCenter3D() {
        return sphere.getCenter3D();
    }

    public JoSValue getRadius() {
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
    public Set<JoSValue> getValues() {
        return new LinkedHashSet<>(sphere.getValues());
    }

    @Override
    public Set<JoPoint> getPoints() {
        return new LinkedHashSet<>(sphere.getPoints());
    }

    @Override
    public List<JoPoint> getIntersection(SketchGeometry geometry) {
        if (geometry instanceof JoSLine) {
            JoSLine line = (JoSLine) geometry;
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