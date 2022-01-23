package eu.bopet.jocadv.core.constraints.regenerative.cosys;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.constraints.regenerative.axis.PointDirectionAxis;
import eu.bopet.jocadv.core.constraints.regenerative.exception.NotOrthogonalVectorException;
import eu.bopet.jocadv.core.constraints.regenerative.plane.PointNormalPlane;
import eu.bopet.jocadv.core.constraints.regenerative.vector.CrossVector;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoAxis;
import eu.bopet.jocadv.core.features.datums.JoCoSys;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;

import java.util.Set;

public class PlanePointDirectionCoordinateSystem implements RegenerativeLink {
    private JoPlane referencePlane;
    private JoPoint referencePoint;
    private JoVector referenceDirection;

    private JoAxis x;
    private JoAxis y;
    private JoAxis z;
    private JoPlane xy;
    private JoPlane yz;
    private JoPlane xz;

    private final JoCoSys resultCoordinateSystem;

    public PlanePointDirectionCoordinateSystem(JoPlane referencePlane,
                                               JoPoint point,
                                               JoVector direction) throws Exception {
        this.referencePlane = referencePlane;
        this.referencePoint = point;
        this.referenceDirection = direction;
        checkOrthogonality();
        createAxesAndPlanes();
        this.resultCoordinateSystem = new JoCoSys(referencePoint, x, y, z, xy, yz, xz, this);
    }

    public PlanePointDirectionCoordinateSystem(JoPlane referencePlane,
                                               JoPoint referencePoint,
                                               JoVector referenceDirection,
                                               JoCoSys resultCoordinateSystem) throws Exception {
        this.referencePlane = referencePlane;
        this.referencePoint = referencePoint;
        this.referenceDirection = referenceDirection;
        checkOrthogonality();
        createAxesAndPlanes();
        this.resultCoordinateSystem = resultCoordinateSystem;
        regenerate();
    }

    private void checkOrthogonality() throws NotOrthogonalVectorException {
        double dotProduct = referencePlane.getNormal().getVector3D().dotProduct(referenceDirection.getVector3D());
        if (dotProduct > JoValue.DEFAULT_TOLERANCE)
            throw new NotOrthogonalVectorException(referencePlane.getNormal(), referenceDirection);
    }

    private void createAxesAndPlanes() throws Exception {
        PointDirectionAxis pointDirectionAxisX = new PointDirectionAxis(referencePoint, this.referenceDirection);
        this.x = (JoAxis) pointDirectionAxisX.getResult();
        PointDirectionAxis pointDirectionAxisZ =
                new PointDirectionAxis(referencePoint, this.referencePlane.getNormal());
        this.z = (JoAxis) pointDirectionAxisZ.getResult();
        CrossVector crossVector = new CrossVector(z.getDirection(), x.getDirection());
        PointDirectionAxis pointDirectionAxisY =
                new PointDirectionAxis(referencePoint, (JoVector) crossVector.getResult());
        this.y = (JoAxis) pointDirectionAxisY.getResult();
        PointNormalPlane pointNormalPlane1 = new PointNormalPlane(referencePoint, this.z.getDirection());
        this.xy = (JoPlane) pointNormalPlane1.getResult();
        PointNormalPlane pointNormalPlane2 = new PointNormalPlane(referencePoint, this.x.getDirection());
        this.yz = (JoPlane) pointNormalPlane2.getResult();
        PointNormalPlane pointNormalPlane3 = new PointNormalPlane(referencePoint, this.y.getDirection());
        this.xz = (JoPlane) pointNormalPlane3.getResult();
    }

    public void setReferencePlane(JoPlane referencePlane) throws Exception {
        this.referencePlane = referencePlane;
        regenerate();
    }

    public void setReferencePoint(JoPoint referencePoint) throws Exception {
        this.referencePoint = referencePoint;
        regenerate();
    }

    public void setReferenceDirection(JoVector referenceDirection) throws Exception {
        this.referenceDirection = referenceDirection;
        regenerate();
    }


    @Override
    public void regenerate() throws Exception {
        if (referencePlane.getRegenerativeLink() != null) referencePlane.getRegenerativeLink().regenerate();
        if (referencePoint.getRegenerativeLink() != null) referencePoint.getRegenerativeLink().regenerate();
        if (referenceDirection.getRegenerativeLink() != null) referenceDirection.getRegenerativeLink().regenerate();
        checkOrthogonality();
        x.getRegenerativeLink().regenerate();
        z.getRegenerativeLink().regenerate();
        y.getRegenerativeLink().regenerate();
        xy.getRegenerativeLink().regenerate();
        yz.getRegenerativeLink().regenerate();
        xz.getRegenerativeLink().regenerate();
    }

    @Override
    public Feature getResult() {
        return resultCoordinateSystem;
    }

    @Override
    public Set<JoValue> getValues() {
        Set<JoValue> result = referencePlane.getValues();
        result.addAll(referencePoint.getValues());
        return result;
    }

    @Override
    public String toString() {
        return "PlanePointDirectionCoordinateSystem{" +
                "referencePlane=" + referencePlane +
                ", referencePoint=" + referencePoint +
                ", referenceDirection=" + referenceDirection +
                ", resultCoordinateSystem=" + resultCoordinateSystem +
                '}';
    }
}
