package eu.bopet.jocadv.core.constraints.regenerative.point;

import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.HashSet;
import java.util.Set;

public class ToPlaneProjectedPoint implements RegenerativeLink {
    private final JoPoint resultPoint;
    private JoPlane referencePlane;
    private JoPoint referencePoint;

    public ToPlaneProjectedPoint(JoPlane referencePlane, JoPoint referencePoint) {
        this.referencePlane = referencePlane;
        this.referencePoint = referencePoint;
        Vector3D projectedPoint = (Vector3D)
                referencePlane.getPlane().project(referencePoint.getVector().getVector3D());
        this.resultPoint = new JoPoint(new JoVector(
                new JoValue(JoValue.USER, projectedPoint.getX()),
                new JoValue(JoValue.USER, projectedPoint.getY()),
                new JoValue(JoValue.USER, projectedPoint.getZ()), null),
                this);
    }

    public ToPlaneProjectedPoint(JoPlane referencePlane, JoPoint referencePoint, JoPoint resultPoint) throws Exception {
        this.referencePlane = referencePlane;
        this.referencePoint = referencePoint;
        this.resultPoint = resultPoint;
        regenerate();
    }

    public void setReferencePlane(JoPlane referencePlane) throws Exception {
        this.referencePlane = referencePlane;
        regenerate();
    }

    public void setReferencePoint(JoPoint referencePoint) throws Exception {
        this.referencePoint = referencePoint;
        regenerate();
    }

    @Override
    public void regenerate() throws Exception {
        if (referencePlane.getRegenerativeLink() != null) referencePlane.getRegenerativeLink().regenerate();
        if (referencePoint.getRegenerativeLink() != null) referencePoint.getRegenerativeLink().regenerate();
        Vector3D projectedPoint = (Vector3D)
                referencePlane.getPlane().project(referencePoint.getVector().getVector3D());
        this.resultPoint.getVector().getX().set(projectedPoint.getX());
        this.resultPoint.getVector().getY().set(projectedPoint.getY());
        this.resultPoint.getVector().getZ().set(projectedPoint.getZ());
    }

    @Override
    public JoFeature getResult() {
        return resultPoint;
    }

    @Override
    public Set<JoValue> getValues() {
        Set<JoValue> result = new HashSet<>(referencePlane.getValues());
        result.addAll(referencePoint.getValues());
        return result;
    }

    @Override
    public String toString() {
        return "ProjectedPoint{" +
                "referencePlane=" + referencePlane +
                ", referencePoint=" + referencePoint +
                ", resultPoint=" + resultPoint +
                '}';
    }
}
