package eu.bopet.jocadv.core.constraints.regenerative.axis;

import eu.bopet.jocadv.core.constraints.regenerative.exception.ParallelFeatureException;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.sketch.JoSValue;
import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoAxis;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.apache.commons.math3.geometry.euclidean.threed.Line;
import org.apache.commons.math3.geometry.euclidean.threed.Plane;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.HashSet;
import java.util.Set;

public class TwoPlaneAxis implements RegenerativeLink {
    private final JoAxis resultAxis;
    private JoPlane referencePlane1;
    private JoPlane referencePlane2;

    public TwoPlaneAxis(JoPlane referencePlane1, JoPlane referencePlane2) throws Exception {
        this.referencePlane1 = referencePlane1;
        this.referencePlane2 = referencePlane2;
        Plane plane1 = referencePlane1.getPlane();
        Plane plane2 = referencePlane2.getPlane();
        Line line = plane1.intersection(plane2);
        if (line == null) throw new ParallelFeatureException(referencePlane1, referencePlane2);
        Vector3D point3D = line.getOrigin();
        Vector3D direction3D = line.getDirection();
        JoSValue pointX = new JoSValue(JoSValue.USER, point3D.getX());
        JoSValue pointY = new JoSValue(JoSValue.USER, point3D.getY());
        JoSValue pointZ = new JoSValue(JoSValue.USER, point3D.getZ());
        JoSValue directionX = new JoSValue(JoSValue.USER, direction3D.getX());
        JoSValue directionY = new JoSValue(JoSValue.USER, direction3D.getY());
        JoSValue directionZ = new JoSValue(JoSValue.USER, direction3D.getZ());
        JoVector joVector = new JoVector(pointX, pointY, pointZ, null);
        JoPoint joPoint = new JoPoint(joVector, null);
        JoVector joDirection = new JoVector(directionX, directionY, directionZ, null);
        this.resultAxis = new JoAxis(joPoint, joDirection, this);
    }

    public TwoPlaneAxis(JoPlane referencePlane1, JoPlane referencePlane2, JoAxis resultAxis) throws Exception {
        this.referencePlane1 = referencePlane1;
        this.referencePlane2 = referencePlane2;
        this.resultAxis = resultAxis;
        regenerate();
    }

    public void setReferencePlane1(JoPlane referencePlane1) throws Exception {
        this.referencePlane1 = referencePlane1;
        regenerate();
    }

    public void setReferencePlane2(JoPlane referencePlane2) throws Exception {
        this.referencePlane2 = referencePlane2;
        regenerate();
    }

    @Override
    public void regenerate() throws Exception {
        Plane plane1 = referencePlane1.getPlane();
        Plane plane2 = referencePlane2.getPlane();
        Line line = plane1.intersection(plane2);
        if (line == null) throw new ParallelFeatureException(referencePlane1, referencePlane2);
        Vector3D point3D = line.getOrigin();
        Vector3D direction3D = line.getDirection();
        this.resultAxis.getPoint().getVector().getX().set(point3D.getX());
        this.resultAxis.getPoint().getVector().getY().set(point3D.getY());
        this.resultAxis.getPoint().getVector().getZ().set(point3D.getZ());
        this.resultAxis.getDirection().getX().set(direction3D.getX());
        this.resultAxis.getDirection().getY().set(direction3D.getY());
        this.resultAxis.getDirection().getZ().set(direction3D.getZ());
    }

    @Override
    public JoFeature getResult() {
        return resultAxis;
    }

    @Override
    public Set<JoSValue> getValues() {
        Set<JoSValue> result = new HashSet<>(referencePlane1.getValues());
        result.addAll(referencePlane2.getValues());
        return result;
    }

    @Override
    public String toString() {
        return "TwoPlaneAxis{" +
                "referencePlane1=" + referencePlane1 +
                ", referencePlane2=" + referencePlane2 +
                ", resultAxis=" + resultAxis +
                '}';
    }
}
