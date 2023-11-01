package eu.bopet.jocadv.core.constraints.regenerative.plane;

import eu.bopet.jocadv.core.constraints.regenerative.exception.NotOrthogonalException;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.sketch.JoSValue;
import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.datums.JoAxis;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.apache.commons.math3.geometry.euclidean.threed.Rotation;
import org.apache.commons.math3.geometry.euclidean.threed.RotationConvention;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.HashSet;
import java.util.Set;

public class AxisAngleToPlanePlane implements RegenerativeLink {
    private final JoVector normal;
    private final PointNormalPlane pointNormalPlane;
    private final JoPlane resultPlane;
    private JoAxis referenceAxis;
    private JoPlane referencePlane;
    private JoSValue referenceAngle;

    public AxisAngleToPlanePlane(JoAxis referenceAxis,
                                 JoPlane referencePlane, JoSValue referenceAngle) throws Exception {
        this.referenceAxis = referenceAxis;
        this.referencePlane = referencePlane;
        this.referenceAngle = referenceAngle;
        Vector3D rotationAxis = referenceAxis.getDirection().getVector3D();
        Vector3D vector = referencePlane.getNormal().getVector3D();
        double crossProductLength = rotationAxis.crossProduct(vector).getNormSq();
        if (crossProductLength < JoSValue.DEFAULT_TOLERANCE) {
            throw new NotOrthogonalException(referenceAxis, referencePlane);
        }
        Rotation rotation = new Rotation(rotationAxis, this.referenceAngle.get(), RotationConvention.VECTOR_OPERATOR);
        Vector3D newVector = rotation.applyTo(vector);
        JoSValue x = new JoSValue(JoSValue.USER, newVector.getX());
        JoSValue y = new JoSValue(JoSValue.USER, newVector.getY());
        JoSValue z = new JoSValue(JoSValue.USER, newVector.getZ());
        normal = new JoVector(x, y, z, null);
        pointNormalPlane = new PointNormalPlane(referenceAxis.getPoint(), normal);
        JoPlane result = (JoPlane) pointNormalPlane.getResult();
        this.resultPlane = new JoPlane(result.getX(), result.getY(), result.getZ(), result.getD(), this);
    }

    public AxisAngleToPlanePlane(JoAxis referenceAxis,
                                 JoPlane referencePlane,
                                 JoSValue referenceAngle, JoPlane resultPlane) throws Exception {
        this.referenceAxis = referenceAxis;
        this.referencePlane = referencePlane;
        this.referenceAngle = referenceAngle;
        Vector3D rotationAxis = referenceAxis.getDirection().getVector3D();
        Vector3D vector = referencePlane.getNormal().getVector3D();
        double crossProductLength = rotationAxis.crossProduct(vector).getNormSq();
        if (crossProductLength < JoSValue.DEFAULT_TOLERANCE) {
            throw new NotOrthogonalException(referenceAxis, referencePlane);
        }
        Rotation rotation = new Rotation(rotationAxis, referenceAngle.get(), RotationConvention.VECTOR_OPERATOR);
        Vector3D newVector = rotation.applyTo(vector);
        JoSValue x = new JoSValue(JoSValue.USER, newVector.getX());
        JoSValue y = new JoSValue(JoSValue.USER, newVector.getY());
        JoSValue z = new JoSValue(JoSValue.USER, newVector.getZ());
        normal = new JoVector(x, y, z, null);
        pointNormalPlane = new PointNormalPlane(referenceAxis.getPoint(), normal);
        this.resultPlane = resultPlane;
        regenerate();
    }

    public void setReferenceAxis(JoAxis referenceAxis) throws Exception {
        this.referenceAxis = referenceAxis;
        regenerate();
    }

    public void setReferencePlane(JoPlane referencePlane) throws Exception {
        this.referencePlane = referencePlane;
        regenerate();
    }

    public void setReferenceAngle(JoSValue referenceAngle) throws Exception {
        this.referenceAngle = referenceAngle;
        regenerate();
    }

    @Override
    public void regenerate() throws Exception {
        if (referenceAxis.getRegenerativeLink() != null) referenceAxis.getRegenerativeLink().regenerate();
        if (referencePlane.getRegenerativeLink() != null) referencePlane.getRegenerativeLink().regenerate();
        Vector3D rotationAxis = referenceAxis.getDirection().getVector3D();
        Vector3D vector = referencePlane.getNormal().getVector3D();
        double crossProductLength = rotationAxis.crossProduct(vector).getNormSq();
        if (crossProductLength < JoSValue.DEFAULT_TOLERANCE) {
            throw new NotOrthogonalException(referenceAxis, referencePlane);
        }
        Rotation rotation = new Rotation(rotationAxis, referenceAngle.get(), RotationConvention.VECTOR_OPERATOR);
        Vector3D newVector = rotation.applyTo(vector);
        normal.getX().set(newVector.getX());
        normal.getY().set(newVector.getY());
        normal.getZ().set(newVector.getZ());
        pointNormalPlane.regenerate();
    }

    @Override
    public JoFeature getResult() {
        return resultPlane;
    }

    @Override
    public Set<JoSValue> getValues() {
        Set<JoSValue> result = new HashSet<>(referenceAxis.getValues());
        result.addAll(referencePlane.getValues());
        result.add(referenceAngle);
        return result;
    }

    @Override
    public String toString() {
        return "AxisAngleDirectionPlane{" +
                "referenceAxis=" + referenceAxis +
                ", referencePlane=" + referencePlane +
                ", referenceAngle=" + referenceAngle +
                ", resultPlane=" + resultPlane +
                '}';
    }
}
