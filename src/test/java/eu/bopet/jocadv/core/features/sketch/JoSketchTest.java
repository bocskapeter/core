package eu.bopet.jocadv.core.features.sketch;


import eu.bopet.jocadv.core.constraints.feature.*;
import eu.bopet.jocadv.core.constraints.sketch.LineParallelToDirection;
import eu.bopet.jocadv.core.constraints.sketch.LineParallelToLine;
import eu.bopet.jocadv.core.constraints.sketch.PointToPointDistance;
import eu.bopet.jocadv.core.constraints.sketch.SketchConstraint;
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
                new PlanePointDirectionCoordinateSystem(sketchPlane, sketchOrigin, xVector);
        JoCoSys sketchCoordinateSystem = (JoCoSys) planePointDirectionCoordinateSystem.getResult();
        CoordinateSystemSketch coordinateSystemSketch = new CoordinateSystemSketch(sketchCoordinateSystem);
        JoSketch sketch = (JoSketch) coordinateSystemSketch.getResult();

        JoValue x1 = new JoValue(JoValue.VARIABLE, 1.26);
        JoValue y1 = new JoValue(JoValue.VARIABLE, 2.59);
        JoValue z1 = new JoValue(JoValue.VARIABLE, 0.015);

        JoValue x2 = new JoValue(JoValue.VARIABLE, 8.26);
        JoValue y2 = new JoValue(JoValue.VARIABLE, 6.59);
        JoValue z2 = new JoValue(JoValue.VARIABLE, 0.06);

        JoValue x3 = new JoValue(JoValue.VARIABLE, 0.16);
        JoValue y3 = new JoValue(JoValue.VARIABLE, 9.59);
        JoValue z3 = new JoValue(JoValue.VARIABLE, -0.089);

        JoValue x4 = new JoValue(JoValue.VARIABLE, 9.16);
        JoValue y4 = new JoValue(JoValue.VARIABLE, 11.59);
        JoValue z4 = new JoValue(JoValue.VARIABLE, -0.2089);

        JoPoint point1 = new JoPoint(new JoVector(x1, y1, z1, null), null);
        JoPoint point2 = new JoPoint(new JoVector(x2, y2, z2, null), null);
        JoPoint point3 = new JoPoint(new JoVector(x3, y3, z3, null), null);
        JoPoint point4 = new JoPoint(new JoVector(x4, y4, z4, null), null);
        JoLine line1 = new JoLine(point1, point2);
        JoLine line2 = new JoLine(point1, point3);
        JoLine line3 = new JoLine(point3, point4);
        JoLine line4 = new JoLine(point4, point2);
        sketch.addGeometry(line1);
        sketch.addGeometry(line2);
        sketch.addGeometry(line3);
        sketch.addGeometry(line4);

        System.out.println("--change offset ");
        offset.set(1.0);
        System.out.println("--start regenerate ");
        sketch.regenerate();
        System.out.println("--regenerate compete");

        JoValue distance1 = new JoValue(JoValue.USER, 6.0);
        PointToPointDistance pointToPointDistance1 = new PointToPointDistance(
                point1, point2, distance1, SketchConstraint.USER_DEFINED);
        sketch.addConstraint(pointToPointDistance1);
        JoValue distance2 = new JoValue(JoValue.USER, 12.0);
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
        System.out.println("1: " + point1 + "\n2: " + point2 + "\n3: " + point3 + "\n4: " + point4);
    }
}