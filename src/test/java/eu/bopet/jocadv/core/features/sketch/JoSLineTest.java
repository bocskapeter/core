package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.constraints.regenerative.sketch.CoordinateSystemSketch;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoCoSys;
import eu.bopet.jocadv.core.features.sketch.exception.SelfIntersectionException;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JoSLineTest {

    @Test
    void testLineLineIntersection() {
        JoSValue x1 = new JoSValue(JoSValue.VARIABLE, 0.0);
        JoSValue y1 = new JoSValue(JoSValue.VARIABLE, 0.0);
        JoSValue z1 = new JoSValue(JoSValue.VARIABLE, 0.0);

        JoSValue x2 = new JoSValue(JoSValue.VARIABLE, 5.0);
        JoSValue y2 = new JoSValue(JoSValue.VARIABLE, 0.0);
        JoSValue z2 = new JoSValue(JoSValue.VARIABLE, 0.0);

        JoSValue x3 = new JoSValue(JoSValue.VARIABLE, 5.0);
        JoSValue y3 = new JoSValue(JoSValue.VARIABLE, 5.0);
        JoSValue z3 = new JoSValue(JoSValue.VARIABLE, 0.0);

        JoSValue x4 = new JoSValue(JoSValue.VARIABLE, 0.0);
        JoSValue y4 = new JoSValue(JoSValue.VARIABLE, 5.0);
        JoSValue z4 = new JoSValue(JoSValue.VARIABLE, 0.0);

        JoPoint point1 = new JoPoint(new JoVector(x1, y1, z1, null), null);
        point1.setName("P1");
        JoPoint point2 = new JoPoint(new JoVector(x2, y2, z2, null), null);
        point2.setName("P2");
        JoPoint point3 = new JoPoint(new JoVector(x3, y3, z3, null), null);
        point3.setName("P3");
        JoPoint point4 = new JoPoint(new JoVector(x4, y4, z4, null), null);
        point4.setName("P4");

        JoSLine line1 = new JoSLine(point1, point3);
        line1.setName("L1");
        JoSLine line2 = new JoSLine(point3, point2);
        line2.setName("L2");
        JoSLine line3 = new JoSLine(point2, point4);
        line2.setName("L2");
        JoSLine line4 = new JoSLine(point3, point1);
        line2.setName("L4");
        assert (line1.getIntersection(line2).isEmpty());
        assert (line3.getIntersection(line4).size() == 1);
    }

    @Test
    void testLineCircleIntersection() throws Exception {
        CoordinateSystemSketch coordinateSystemSketch = new CoordinateSystemSketch(JoCoSys.DEFAULT_COORDINATE_SYSTEM);
        JoSketch sketch = (JoSketch) coordinateSystemSketch.getResult();

        JoSValue x1 = new JoSValue(JoSValue.VARIABLE, 8.000000000001);
        JoSValue y1 = new JoSValue(JoSValue.VARIABLE, 0.0);
        JoSValue z1 = new JoSValue(JoSValue.VARIABLE, 0.0);

        JoSValue x2 = new JoSValue(JoSValue.VARIABLE, -0.00000000000000001);
        JoSValue y2 = new JoSValue(JoSValue.VARIABLE, 0.0);
        JoSValue z2 = new JoSValue(JoSValue.VARIABLE, 0.0);

        JoSValue x3 = new JoSValue(JoSValue.VARIABLE, 4.0);
        JoSValue y3 = new JoSValue(JoSValue.VARIABLE, 3.0);
        JoSValue z3 = new JoSValue(JoSValue.VARIABLE, 0.0);

        JoSValue radius = new JoSValue(JoSValue.USER, 5.0);

        JoPoint point1 = new JoPoint(new JoVector(x1, y1, z1, null), null);
        point1.setName("P1");
        JoPoint point2 = new JoPoint(new JoVector(x2, y2, z2, null), null);
        point2.setName("P2");
        JoPoint centerPoint = new JoPoint(new JoVector(x3, y3, z3, null), null);
        centerPoint.setName("Center");

        JoSLine line1 = new JoSLine(point1, point2);
        line1.setName("L1");
        JoSCircle circle = new JoSCircle(new JoSSphere(centerPoint, radius), sketch.getSketchPlane());
        sketch.addGeometry(line1);
        Throwable exception = assertThrows(SelfIntersectionException.class, () -> sketch.addGeometry(circle));
        assertEquals(SelfIntersectionException.class, exception.getClass());
    }

    @Test
    void testLineArcIntersection() throws Exception {


    }
}
