package eu.bopet.jocadv.core.constraints.regenerative.point;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.Set;

public class ProjectedPoint implements RegenerativeLink {
    private final JoPlane referencePlane;
    private final JoPoint referencePoint;
    private final JoPoint resultPoint;

    public ProjectedPoint(JoPlane referencePlane, JoPoint referencePoint) {
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
    public Feature getResult() {
        return resultPoint;
    }

    @Override
    public Set<JoValue> getValues() {
        Set<JoValue> result = referencePlane.getValues();
        result.addAll(referencePoint.getValues());
        return result;
    }
}
