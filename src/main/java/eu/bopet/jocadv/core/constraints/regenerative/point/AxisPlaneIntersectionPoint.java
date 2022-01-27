package eu.bopet.jocadv.core.constraints.regenerative.point;

import eu.bopet.jocadv.core.constraints.regenerative.exception.NoIntersectionException;
import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoAxis;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.HashSet;
import java.util.Set;

public class AxisPlaneIntersectionPoint implements RegenerativeLink {
    private JoAxis referenceAxis;
    private JoPlane referencePlane;
    private final JoPoint resultPoint;

    public AxisPlaneIntersectionPoint(JoAxis referenceAxis, JoPlane referencePlane) throws Exception {
        this.referenceAxis = referenceAxis;
        this.referencePlane = referencePlane;
        Vector3D intersectionPoint = referencePlane.getPlane().intersection(referenceAxis.getLine());
        if (intersectionPoint == null ) throw new NoIntersectionException(referenceAxis.getDirection(),referencePlane.getNormal());
        JoValue x = new JoValue(JoValue.USER, intersectionPoint.getX());
        JoValue y = new JoValue(JoValue.USER, intersectionPoint.getY());
        JoValue z = new JoValue(JoValue.USER, intersectionPoint.getZ());
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
        if (intersectionPoint == null ) throw new NoIntersectionException(referenceAxis.getDirection(),referencePlane.getNormal());
        resultPoint.getVector().getX().set(intersectionPoint.getX());
        resultPoint.getVector().getY().set(intersectionPoint.getY());
        resultPoint.getVector().getZ().set(intersectionPoint.getZ());
    }

    @Override
    public Feature getResult() {
        return resultPoint;
    }

    @Override
    public Set<JoValue> getValues() {
        Set<JoValue> result = new HashSet<>(referenceAxis.getValues());
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
