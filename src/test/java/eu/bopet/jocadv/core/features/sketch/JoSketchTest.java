package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.constraints.feature.*;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoAxis;
import eu.bopet.jocadv.core.features.datums.JoCoSys;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.junit.jupiter.api.Test;

class JoSketchTest {

    @Test
    void addConstraint() {
        System.out.println(" init sketch ");
        JoValue offset = new JoValue(JoValue.USER, 0.0);
        OffsetPlane offsetPlane = new OffsetPlane(JoPlane.XY, offset);
        JoPlane sketchPlane = (JoPlane) offsetPlane.getResult();
        ProjectedPoint projectedPoint = new ProjectedPoint(sketchPlane, JoPoint.ORIGIN);
        JoPoint sketchOrigin = (JoPoint) projectedPoint.getResult();
        CoaxialAxis coaxialAxis = new CoaxialAxis(JoAxis.X);
        JoVector xVector = ((JoAxis) coaxialAxis.getResult()).getDirection();
        PlanePointDirectionCoordinateSystem planePointDirectionCoordinateSystem =
                new PlanePointDirectionCoordinateSystem(sketchPlane,sketchOrigin,xVector);
        JoCoSys sketchCoordinateSystem = (JoCoSys) planePointDirectionCoordinateSystem.getResult();
        CoordinateSystemSketch coordinateSystemSketch = new CoordinateSystemSketch(sketchCoordinateSystem);
        JoSketch sketch = (JoSketch) coordinateSystemSketch.getResult();
        System.out.println(" change offset ");
        offset.set(1.0);
        System.out.println(" start regenerate ");
        sketch.regenerate();
        System.out.println(" regenerate compete");


        JoValue x1 = new JoValue(1.26);
        JoValue y1 = new JoValue(2.59);
        JoValue z1 = new JoValue(0.015);

        JoValue x2 = new JoValue(8.26);
        JoValue y2 = new JoValue(6.59);
        JoValue z2 = new JoValue(0.06);

        JoPoint point1 = new JoPoint(new JoVector(x1, y1, z1, null), null);
        JoPoint point2 = new JoPoint(new JoVector(x2, y2, z2, null), null);
        sketch.addGeometry(point1);
        sketch.addGeometry(point2);
    }
}