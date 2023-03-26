package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.constraints.regenerative.sketch.CoordinateSystemSketch;
import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoCoSys;
import eu.bopet.jocadv.core.features.sketch.exception.SelfIntersectionException;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JoLineTest {

    @Test
    void testLineLineIntersection() {
        JoValue x1 = new JoValue(JoValue.VARIABLE, 0.0);
        JoValue y1 = new JoValue(JoValue.VARIABLE, 0.0);
        JoValue z1 = new JoValue(JoValue.VARIABLE, 0.0);

        JoValue x2 = new JoValue(JoValue.VARIABLE, 5.0);
        JoValue y2 = new JoValue(JoValue.VARIABLE, 0.0);
        JoValue z2 = new JoValue(JoValue.VARIABLE, 0.0);

        JoValue x3 = new JoValue(JoValue.VARIABLE, 5.0);
        JoValue y3 = new JoValue(JoValue.VARIABLE, 5.0);
        JoValue z3 = new JoValue(JoValue.VARIABLE, 0.0);

        JoValue x4 = new JoValue(JoValue.VARIABLE, 0.0);
        JoValue y4 = new JoValue(JoValue.VARIABLE, 5.0);
        JoValue z4 = new JoValue(JoValue.VARIABLE, 0.0);

        JoPoint point1 = new JoPoint(new JoVector(x1, y1, z1, null), null);
        point1.setName("P1");
        JoPoint point2 = new JoPoint(new JoVector(x2, y2, z2, null), null);
        point2.setName("P2");
        JoPoint point3 = new JoPoint(new JoVector(x3, y3, z3, null), null);
        point3.setName("P3");
        JoPoint point4 = new JoPoint(new JoVector(x4, y4, z4, null), null);
        point4.setName("P4");

        JoLine line1 = new JoLine(point1, point3);
        line1.setName("L1");
        JoLine line2 = new JoLine(point3, point2);
        line2.setName("L2");
        JoLine line3 = new JoLine(point2, point4);
        line2.setName("L2");
        JoLine line4 = new JoLine(point3, point1);
        line2.setName("L4");
        assert (line1.getIntersection(line2).isEmpty());
        assert (line3.getIntersection(line4).size() == 1);
    }

    @Test
    void testLineCircleIntersection() throws Exception {
        CoordinateSystemSketch coordinateSystemSketch = new CoordinateSystemSketch(JoCoSys.DEFAULT_COORDINATE_SYSTEM);
        JoSketch sketch = (JoSketch) coordinateSystemSketch.getResult();

        JoValue x1 = new JoValue(JoValue.VARIABLE, 8.000000000001);
        JoValue y1 = new JoValue(JoValue.VARIABLE, 0.0);
        JoValue z1 = new JoValue(JoValue.VARIABLE, 0.0);

        JoValue x2 = new JoValue(JoValue.VARIABLE, -0.00000000000000001);
        JoValue y2 = new JoValue(JoValue.VARIABLE, 0.0);
        JoValue z2 = new JoValue(JoValue.VARIABLE, 0.0);

        JoValue x3 = new JoValue(JoValue.VARIABLE, 4.0);
        JoValue y3 = new JoValue(JoValue.VARIABLE, 3.0);
        JoValue z3 = new JoValue(JoValue.VARIABLE, 0.0);

        JoValue radius = new JoValue(JoValue.USER, 5.0);

        JoPoint point1 = new JoPoint(new JoVector(x1, y1, z1, null), null);
        point1.setName("P1");
        JoPoint point2 = new JoPoint(new JoVector(x2, y2, z2, null), null);
        point2.setName("P2");
        JoPoint centerPoint = new JoPoint(new JoVector(x3, y3, z3, null), null);
        centerPoint.setName("Center");

        JoLine line1 = new JoLine(point1, point2);
        line1.setName("L1");
        JoCircle circle = new JoCircle(new JoSphere(centerPoint, radius), sketch.getSketchPlane());
        sketch.addGeometry(line1);
        Throwable exception = assertThrows(SelfIntersectionException.class, () -> sketch.addGeometry(circle));
        assertEquals(SelfIntersectionException.class, exception.getClass());
    }

    @Test
    void testLineArcIntersection() throws Exception {


    }
}
