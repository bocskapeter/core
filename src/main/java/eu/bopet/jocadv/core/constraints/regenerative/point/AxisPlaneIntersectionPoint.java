package eu.bopet.jocadv.core.constraints.regenerative.point;

import eu.bopet.jocadv.core.constraints.regenerative.exception.NoIntersectionException;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.sketch.JoSValue;
import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoAxis;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.HashSet;
import java.util.Set;

public class AxisPlaneIntersectionPoint implements RegenerativeLink {
    private final JoPoint resultPoint;
    private JoAxis referenceAxis;
    private JoPlane referencePlane;

    public AxisPlaneIntersectionPoint(JoAxis referenceAxis, JoPlane referencePlane) throws Exception {
        this.referenceAxis = referenceAxis;
        this.referencePlane = referencePlane;
        Vector3D intersectionPoint = referencePlane.getPlane().intersection(referenceAxis.getLine());
        if (intersectionPoint == null)
            throw new NoIntersectionException(referenceAxis, referencePlane);
        JoSValue x = new JoSValue(JoSValue.USER, intersectionPoint.getX());
        JoSValue y = new JoSValue(JoSValue.USER, intersectionPoint.getY());
        JoSValue z = new JoSValue(JoSValue.USER, intersectionPoint.getZ());
        JoVector vector = new JoVector(x, y, z, null);
        this.resultPoint = new JoPoint(vector, this);
    }

    public AxisPlaneIntersectionPoint(JoAxis referenceAxis, JoPlane referencePlane, JoPoint resultPoint) throws Exception {
        this.referenceAxis = referenceAxis;
        this.referencePlane = referencePlane;
        this.resultPoint = resultPoint;
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

    @Override
    public void regenerate() throws Exception {
        if (referenceAxis.getRegenerativeLink() != null) referenceAxis.getRegenerativeLink().regenerate();
        if (referencePlane.getRegenerativeLink() != null) referencePlane.getRegenerativeLink().regenerate();
        Vector3D intersectionPoint = referencePlane.getPlane().intersection(referenceAxis.getLine());
        if (intersectionPoint == null)
            throw new NoIntersectionException(referenceAxis, referencePlane);
        resultPoint.getVector().getX().set(intersectionPoint.getX());
        resultPoint.getVector().getY().set(intersectionPoint.getY());
        resultPoint.getVector().getZ().set(intersectionPoint.getZ());
    }

    @Override
    public JoFeature getResult() {
        return resultPoint;
    }

    @Override
    public Set<JoSValue> getValues() {
        Set<JoSValue> result = new HashSet<>(referenceAxis.getValues());
        result.addAll(referencePlane.getValues());
        return result;
    }

    @Override
    public String toString() {
        return "AxisPlaneIntersectionPoint{" +
                "referenceAxis=" + referenceAxis +
                ", referencePlane=" + referencePlane +
                ", resultPoint=" + resultPoint +
                '}';
    }
}
