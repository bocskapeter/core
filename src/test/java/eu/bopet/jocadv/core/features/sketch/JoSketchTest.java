package eu.bopet.jocadv.core.features.sketch;


import eu.bopet.jocadv.core.constraints.regenerative.axis.CoaxialAxis;
import eu.bopet.jocadv.core.constraints.regenerative.cosys.PlanePointDirectionCoordinateSystem;
import eu.bopet.jocadv.core.constraints.regenerative.plane.OffsetPlane;
import eu.bopet.jocadv.core.constraints.regenerative.point.ToPlaneProjectedPoint;
import eu.bopet.jocadv.core.constraints.regenerative.sketch.CoordinateSystemSketch;
import eu.bopet.jocadv.core.constraints.sketch.LineParallelToDirection;
import eu.bopet.jocadv.core.constraints.sketch.LineParallelToLine;
import eu.bopet.jocadv.core.constraints.sketch.LinePerpendicularToLine;
import eu.bopet.jocadv.core.constraints.sketch.PointToLineDistance;
import eu.bopet.jocadv.core.constraints.sketch.PointToPlaneDistance;
import eu.bopet.jocadv.core.constraints.sketch.PointToPointDistance;
import eu.bopet.jocadv.core.constraints.sketch.SketchConstraint;
import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoAxis;
import eu.bopet.jocadv.core.features.datums.JoCoSys;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.sketch.exception.SelfIntersectionException;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JoSketchTest {

    @Test
    void testIntersection() throws Exception {
        CoordinateSystemSketch coordinateSystemSketch = new CoordinateSystemSketch(JoCoSys.DEFAULT_COORDINATE_SYSTEM);
        JoSketch sketch = (JoSketch) coordinateSystemSketch.getResult();

        JoValue x1 = new JoValue(JoValue.VARIABLE, 0.0);
        JoValue y1 = new JoValue(JoValue.VARIABLE, 0.0);
        JoValue z1 = new JoValue(JoValue.VARIABLE, 0.0);

        JoValue x2 = new JoValue(JoValue.VARIABLE, 5.0);
        JoValue y2 = new JoValue(JoValue.VARIABLE, 0.0);
        JoValue z2 = new JoValue(JoValue.VARIABLE, 0.0);

        JoValue x3 = new JoValue(JoValue.VARIABLE, 5.0);
        JoValue y3 = new JoValue(JoValue.VARIABLE, 5.);
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
        line3.setName("L3");
        JoLine line4 = new JoLine(point4, point1);
        line4.setName("L4");
        sketch.addGeometry(line1);
        sketch.addGeometry(line2);
        Throwable exception = assertThrows(SelfIntersectionException.class, () -> sketch.addGeometry(line3));
        assertEquals(SelfIntersectionException.class, exception.getClass());
    }

    @Test
    void addConstraint() throws Exception {
        System.out.println(" init sketch ");
        JoValue offset = new JoValue(JoValue.USER, 0.5);
        OffsetPlane offsetPlane = new OffsetPlane(JoPlane.XY, offset);
        JoPlane sketchPlane = (JoPlane) offsetPlane.getResult();
        ToPlaneProjectedPoint toPlaneProjectedPoint = new ToPlaneProjectedPoint(sketchPlane, JoPoint.ORIGIN);
        JoPoint sketchOrigin = (JoPoint) toPlaneProjectedPoint.getResult();
        CoaxialAxis coaxialAxis = new CoaxialAxis(JoAxis.X);
        JoVector xVector = ((JoAxis) coaxialAxis.getResult()).getDirection();
        PlanePointDirectionCoordinateSystem planePointDirectionCoordinateSystem =
                new PlanePointDirectionCoordinateSystem(sketchPlane, sketchOrigin, xVector);
        JoCoSys sketchCoordinateSystem = (JoCoSys) planePointDirectionCoordinateSystem.getResult();
        CoordinateSystemSketch coordinateSystemSketch = new CoordinateSystemSketch(sketchCoordinateSystem);
        JoSketch sketch = (JoSketch) coordinateSystemSketch.getResult();

        JoValue x1 = new JoValue(JoValue.VARIABLE, 1.26);
        JoValue y1 = new JoValue(JoValue.VARIABLE, 2.59);
        JoValue z1 = new JoValue(JoValue.VARIABLE, 0.015);

        JoValue x2 = new JoValue(JoValue.VARIABLE, 8.1);
        JoValue y2 = new JoValue(JoValue.VARIABLE, 2.95);
        JoValue z2 = new JoValue(JoValue.VARIABLE, 0.06);

        JoValue x3 = new JoValue(JoValue.VARIABLE, 0.956);
        JoValue y3 = new JoValue(JoValue.VARIABLE, 9.59);
        JoValue z3 = new JoValue(JoValue.VARIABLE, -0.089);

        JoValue x4 = new JoValue(JoValue.VARIABLE, 6.3);
        JoValue y4 = new JoValue(JoValue.VARIABLE, 10.29);
        JoValue z4 = new JoValue(JoValue.VARIABLE, -0.2089);

        JoValue x5 = new JoValue(JoValue.VARIABLE, 8.16);
        JoValue y5 = new JoValue(JoValue.VARIABLE, 7.892);
        JoValue z5 = new JoValue(JoValue.VARIABLE, 0.2089);

        JoValue x6 = new JoValue(JoValue.VARIABLE, 6.86);
        JoValue y6 = new JoValue(JoValue.VARIABLE, 7.89);
        JoValue z6 = new JoValue(JoValue.VARIABLE, -0.109);

        JoValue x7 = new JoValue(JoValue.VARIABLE, 2.86);
        JoValue y7 = new JoValue(JoValue.VARIABLE, 3.49);
        JoValue z7 = new JoValue(JoValue.VARIABLE, -1.09);

        JoPoint point1 = new JoPoint(new JoVector(x1, y1, z1, null), null);
        point1.setName("P1");
        JoPoint point2 = new JoPoint(new JoVector(x2, y2, z2, null), null);
        point2.setName("P2");
        JoPoint point3 = new JoPoint(new JoVector(x3, y3, z3, null), null);
        point3.setName("P3");
        JoPoint point4 = new JoPoint(new JoVector(x4, y4, z4, null), null);
        point4.setName("P4");
        JoPoint point5 = new JoPoint(new JoVector(x5, y5, z5, null), null);
        point5.setName("P5");
        JoPoint point6 = new JoPoint(new JoVector(x6, y6, z6, null), null);
        point6.setName("P6");
        JoPoint point7 = new JoPoint(new JoVector(x7, y7, z7, null), null);
        point7.setName("P7");
        JoLine line1 = new JoLine(point1, point2);
        line1.setName("L1");
        JoLine line2 = new JoLine(point1, point3);
        line2.setName("L2");
        JoLine line3 = new JoLine(point3, point4);
        line3.setName("L3");
        JoLine line4 = new JoLine(point5, point2);
        line4.setName("L4");
        double r = (point5.distance(point6) + point4.distance(point6)) / 2.0;
        JoValue radius = new JoValue(JoValue.USER, r);
        JoArc arc = new JoArc(point6, radius, sketchCoordinateSystem.getXy(), point5, point4);
        arc.setName("A1");
        sketch.addGeometry(line1);
        sketch.addGeometry(line2);
        sketch.addGeometry(line3);
        sketch.addGeometry(line4);
        sketch.addGeometry(arc);
        sketch.addGeometry(point7);

        radius.set(2.0);
        sketch.regenerate();

        JoValue distance1 = new JoValue(JoValue.USER, 7.0);
        PointToPointDistance pointToPointDistance1 = new PointToPointDistance(
                point1, point2, distance1, SketchConstraint.USER_DEFINED);
        sketch.addConstraint(pointToPointDistance1);
        JoValue distance2 = new JoValue(JoValue.USER, 7.5);
        PointToPointDistance pointToPointDistance2 = new PointToPointDistance(
                point1, point3, distance2, SketchConstraint.USER_DEFINED);
        sketch.addConstraint(pointToPointDistance2);
        System.out.println("--change offset ");
        offset.set(2.0);
        System.out.println("--start regenerate ");
        sketch.regenerate();
        System.out.println("--regenerate compete");


        LineParallelToDirection lineParallelToDirection1 = new LineParallelToDirection(
                SketchConstraint.USER_DEFINED, line1, sketchCoordinateSystem.getX().getDirection());
        sketch.addConstraint(lineParallelToDirection1);
        LineParallelToDirection lineParallelToDirection2 = new LineParallelToDirection(
                SketchConstraint.USER_DEFINED, line2, sketchCoordinateSystem.getY().getDirection());
        sketch.addConstraint(lineParallelToDirection2);
        LineParallelToLine lineParallelToLine1 = new LineParallelToLine(
                SketchConstraint.USER_DEFINED, line1, line3);
        sketch.addConstraint(lineParallelToLine1);
        LineParallelToLine lineParallelToLine2 = new LineParallelToLine(
                SketchConstraint.USER_DEFINED, line2, line4);
        sketch.addConstraint(lineParallelToLine2);

        System.out.println("--change offset ");
        offset.set(-2.0);
        System.out.println("--start regenerate ");
        sketch.regenerate();
        System.out.println("--regenerate compete");

        JoValue distance3 = new JoValue(JoValue.USER, 1.0);

        PointToPlaneDistance pointToPlaneDistance1 = new PointToPlaneDistance(sketchCoordinateSystem.getYz(), point1, distance3, SketchConstraint.USER_DEFINED);
        sketch.addConstraint(pointToPlaneDistance1);

        JoValue distance4 = new JoValue(JoValue.USER, 2.0);

        PointToPlaneDistance pointToPlaneDistance2 = new PointToPlaneDistance(sketchCoordinateSystem.getXz(), point1, distance4, SketchConstraint.USER_DEFINED);
        sketch.addConstraint(pointToPlaneDistance2);

        JoValue distance5 = new JoValue(JoValue.USER, 1.0);
        PointToLineDistance pointToLineDistance3 = new PointToLineDistance(line2, point7, distance5, SketchConstraint.USER_DEFINED);
        sketch.addConstraint(pointToLineDistance3);

        JoValue distance6 = new JoValue(JoValue.USER, 1.5);
        PointToLineDistance pointToLineDistance4 = new PointToLineDistance(line1, point7, distance6, SketchConstraint.USER_DEFINED);
        sketch.addConstraint(pointToLineDistance4);

        LinePerpendicularToLine linePerpendicularToLine1 = new LinePerpendicularToLine(SketchConstraint.USER_DEFINED, arc.getLine1(), line4);
        sketch.addConstraint(linePerpendicularToLine1);

        LinePerpendicularToLine linePerpendicularToLine2 = new LinePerpendicularToLine(SketchConstraint.USER_DEFINED, arc.getLine2(), line3);
        sketch.addConstraint(linePerpendicularToLine2);

        System.out.println("--change offset ");
        offset.set(5.0);
        System.out.println("--start regenerate ");
        sketch.regenerate();
        System.out.println("--regenerate complete");

        sketch.close();

        System.out.println(sketch.getPoints().size() + " points:");
        for (JoPoint point : sketch.getPoints()) {
            System.out.println(point);
        }

        System.out.println(sketch.getConstraints().size() + " constraints:");
        for (SketchConstraint sketchConstraint : sketch.getConstraints()) {
            System.out.println(sketchConstraint);
        }

        System.out.println(sketch.getGeometries().size() + " geometries:");
        for (SketchGeometry geometry : sketch.getGeometries()) {
            System.out.println(geometry);
        }
    }
}