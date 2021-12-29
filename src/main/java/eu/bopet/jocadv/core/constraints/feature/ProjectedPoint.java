package eu.bopet.jocadv.core.constraints.feature;

import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

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
                new JoValue(projectedPoint.getX()),
                new JoValue(projectedPoint.getY()),
                new JoValue(projectedPoint.getZ()), null),
                this);
    }

    @Override
    public void regenerate() {
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
}
