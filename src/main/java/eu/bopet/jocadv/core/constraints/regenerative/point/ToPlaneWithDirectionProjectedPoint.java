package eu.bopet.jocadv.core.constraints.regenerative.point;

import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.constraints.regenerative.exception.NoIntersectionException;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.apache.commons.math3.geometry.euclidean.threed.Line;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.HashSet;
import java.util.Set;

public class ToPlaneWithDirectionProjectedPoint implements RegenerativeLink {
    private JoPlane referencePlane;
    private JoPoint referencePoint;
    private JoVector referenceDirection;

    private final JoPoint resultPoint;

    public ToPlaneWithDirectionProjectedPoint(JoPlane referencePlane, JoPoint referencePoint, JoVector referenceDirection) throws Exception {
        this.referencePlane = referencePlane;
        this.referencePoint = referencePoint;
        this.referenceDirection = referenceDirection;
        double dotProduct = Math.abs(referencePlane.getNormal().getVector3D().dotProduct(referenceDirection.getVector3D()));
        if (dotProduct < JoValue.DEFAULT_TOLERANCE) {
            throw new NoIntersectionException(referencePlane, referenceDirection);
        }
        Vector3D point1st = referencePoint.getVector().getVector3D();
        Vector3D point2nd = point1st.add(referenceDirection.getVector3D());
        Line line = new Line(point1st, point2nd, JoValue.DEFAULT_TOLERANCE);
        Vector3D point = referencePlane.getPlane().intersection(line);
        JoValue x = new JoValue(JoValue.USER, point.getX());
        JoValue y = new JoValue(JoValue.USER, point.getY());
        JoValue z = new JoValue(JoValue.USER, point.getZ());
        JoVector vector = new JoVector(x, y, z, null);
        resultPoint = new JoPoint(vector, this);
    }

    @Override
    public void regenerate() throws Exception {
        if (referencePlane.getRegenerativeLink() != null) referencePlane.getRegenerativeLink().regenerate();
        if (referencePoint.getRegenerativeLink() != null) referencePoint.getRegenerativeLink().regenerate();
        if (referenceDirection.getRegenerativeLink() != null) referenceDirection.getRegenerativeLink().regenerate();
        double dotProduct = Math.abs(referencePlane.getNormal().getVector3D().dotProduct(referenceDirection.getVector3D()));
        if (dotProduct < JoValue.DEFAULT_TOLERANCE) {
            throw new NoIntersectionException(referencePlane, referenceDirection);
        }
        Vector3D point1st = referencePoint.getVector().getVector3D();
        Vector3D point2nd = point1st.add(referenceDirection.getVector3D());
        Line line = new Line(point1st, point2nd, JoValue.DEFAULT_TOLERANCE);
        Vector3D point = referencePlane.getPlane().intersection(line);
        resultPoint.getVector().getX().set(point.getX());
        resultPoint.getVector().getY().set(point.getY());
        resultPoint.getVector().getZ().set(point.getZ());
    }

    @Override
    public JoFeature getResult() {
        return resultPoint;
    }

    @Override
    public Set<JoValue> getValues() {
        Set<JoValue> result = new HashSet<>(referencePlane.getValues());
        result.addAll(referencePoint.getValues());
        result.addAll(referenceDirection.getValues());
        return result;
    }
}
