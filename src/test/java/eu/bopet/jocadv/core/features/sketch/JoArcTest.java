package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.junit.jupiter.api.Test;

public class JoArcTest {

    @Test
    void testPointOnSphere() {
        JoPoint center = new JoPoint(new Vector3D(0.0, 0.0, 0.0));
        JoValue radius = new JoValue(5.0);
        JoPoint p1 = new JoPoint(new Vector3D(3.0, 4.0, 0.0));
        JoSphere sphere = new JoSphere(center, radius);
        assert (sphere.isOn(p1));
        System.out.println("Radius before: " + radius);
        radius.set(5.0 + 1e-11);
        System.out.println("Radius after: " + radius);
        assert (!sphere.isOn(p1));
    }

    @Test
    void testPointOnCircle() throws Exception {
        JoPoint center = new JoPoint(new Vector3D(0.0, 0.0, 5.0));
        JoValue radius = new JoValue(5.0);
        JoPoint p1 = new JoPoint(new Vector3D(3.0, 4.0, 5.0));
        JoSphere sphere = new JoSphere(center, radius);
        JoPlane plane = new JoPlane(0.0, 0.0, 1.0, 5.0);
        JoCircle circle = new JoCircle(sphere, plane);
        assert (circle.isOn(p1));
        radius.set(5.0 + 1e-11);
        assert (!circle.isOn(p1));
    }

    @Test
    void testPointOnArc() throws Exception {
        JoPoint center = new JoPoint(new Vector3D(0.0, 0.0, 5.0));
        JoValue radius = new JoValue(5.0);
        JoPoint testPoint = new JoPoint(new Vector3D(3.0, 4.0, 5.0));
        JoSphere sphere = new JoSphere(center, radius);
        JoPlane plane = new JoPlane(0.0, 0.0, 1.0, 5.0);
        JoCircle circle = new JoCircle(sphere, plane);
        JoPoint p1 = new JoPoint(new Vector3D(5.0, 0.0, 5.0));
        JoPoint p2 = new JoPoint(new Vector3D(0.0, -5.0, 5.0));
        JoArc arc1 = new JoArc(circle, p1, p2);
        assert (arc1.isOn(testPoint));
        JoArc arc2 = new JoArc(circle, p2, p1);
        assert (!arc2.isOn(testPoint));
    }

}
