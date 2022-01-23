package eu.bopet.jocadv.core.constraints.regenerative.plane;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.constraints.regenerative.exception.ParallelVectorException;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.datums.JoAxis;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.apache.commons.math3.geometry.euclidean.threed.Rotation;
import org.apache.commons.math3.geometry.euclidean.threed.RotationConvention;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.Set;

public class AxisAngleDirectionPlane implements RegenerativeLink {
    private JoAxis referenceAxis;
    private JoVector referenceDirection;
    private JoValue referenceAngle;
    private final JoPlane resultPlane;

    private final JoVector normal;
    private final PointNormalPlane pointNormalPlane;

    public AxisAngleDirectionPlane(JoAxis referenceAxis,
                                   JoVector referenceDirection, JoValue referenceAngle) throws Exception {
        this.referenceAxis = referenceAxis;
        this.referenceDirection = referenceDirection;
        this.referenceAngle = referenceAngle;
        Vector3D rotationAxis = referenceAxis.getDirection().getVector3D();
        Vector3D vector = referenceDirection.getVector3D();
        double crossProductLength = rotationAxis.crossProduct(vector).getNormSq();
        if (crossProductLength < JoValue.DEFAULT_TOLERANCE) {
            throw new ParallelVectorException(referenceAxis.getDirection(), referenceDirection);
        }
        Rotation rotation = new Rotation(rotationAxis, this.referenceAngle.get(), RotationConvention.VECTOR_OPERATOR);
        Vector3D newVector = rotation.applyTo(vector);
        JoValue x = new JoValue(JoValue.USER, newVector.getX());
        JoValue y = new JoValue(JoValue.USER, newVector.getY());
        JoValue z = new JoValue(JoValue.USER, newVector.getZ());
        normal = new JoVector(x, y, z, null);
        pointNormalPlane = new PointNormalPlane(referenceAxis.getPoint(), normal);
        JoPlane result = (JoPlane) pointNormalPlane.getResult();
        this.resultPlane = new JoPlane(result.getX(), result.getY(), result.getZ(), result.getD(), this);
    }

    public AxisAngleDirectionPlane(JoAxis referenceAxis,
                                   JoVector referenceDirection,
                                   JoValue referenceAngle, JoPlane resultPlane) throws Exception {
        this.referenceAxis = referenceAxis;
        this.referenceDirection = referenceDirection;
        this.referenceAngle = referenceAngle;
        Vector3D rotationAxis = referenceAxis.getDirection().getVector3D();
        Vector3D vector = referenceDirection.getVector3D();
        double crossProductLength = rotationAxis.crossProduct(vector).getNormSq();
        if (crossProductLength < JoValue.DEFAULT_TOLERANCE) {
            throw new ParallelVectorException(referenceAxis.getDirection(), referenceDirection);
        }
        Rotation rotation = new Rotation(rotationAxis, referenceAngle.get(), RotationConvention.VECTOR_OPERATOR);
        Vector3D newVector = rotation.applyTo(vector);
        JoValue x = new JoValue(JoValue.USER, newVector.getX());
        JoValue y = new JoValue(JoValue.USER, newVector.getY());
        JoValue z = new JoValue(JoValue.USER, newVector.getZ());
        normal = new JoVector(x, y, z, null);
        pointNormalPlane = new PointNormalPlane(referenceAxis.getPoint(), normal);
        this.resultPlane = resultPlane;
        regenerate();
    }

    public void setReferenceAxis(JoAxis referenceAxis) throws Exception {
        this.referenceAxis = referenceAxis;
        regenerate();
    }

    public void setReferenceDirection(JoVector referenceDirection) throws Exception {
        this.referenceDirection = referenceDirection;
        regenerate();
    }

    public void setReferenceAngle(JoValue referenceAngle) throws Exception {
        this.referenceAngle = referenceAngle;
        regenerate();
    }

    @Override
    public void regenerate() throws Exception {
        if (referenceAxis.getRegenerativeLink() != null) referenceAxis.getRegenerativeLink().regenerate();
        if (referenceDirection.getRegenerativeLink() != null) referenceDirection.getRegenerativeLink().regenerate();
        Vector3D rotationAxis = referenceAxis.getDirection().getVector3D();
        Vector3D vector = referenceDirection.getVector3D();
        double crossProductLength = rotationAxis.crossProduct(vector).getNormSq();
        if (crossProductLength < JoValue.DEFAULT_TOLERANCE) {
            throw new ParallelVectorException(referenceAxis.getDirection(), referenceDirection);
        }
        Rotation rotation = new Rotation(rotationAxis, referenceAngle.get(), RotationConvention.VECTOR_OPERATOR);
        Vector3D newVector = rotation.applyTo(vector);
        normal.getX().set(newVector.getX());
        normal.getY().set(newVector.getY());
        normal.getZ().set(newVector.getZ());
        pointNormalPlane.regenerate();
    }

    @Override
    public Feature getResult() {
        return resultPlane;
    }

    @Override
    public Set<JoValue> getValues() {
        Set<JoValue> result = referenceAxis.getValues();
        result.addAll(referenceDirection.getValues());
        result.add(referenceAngle);
        return result;
    }

    @Override
    public String toString() {
        return "AxisAngleDirectionPlane{" +
                "referenceAxis=" + referenceAxis +
                ", referenceDirection=" + referenceDirection +
                ", referenceAngle=" + referenceAngle +
                ", resultPlane=" + resultPlane +
                '}';
    }
}
