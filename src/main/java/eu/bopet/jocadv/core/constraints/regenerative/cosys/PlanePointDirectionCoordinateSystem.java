package eu.bopet.jocadv.core.constraints.regenerative.cosys;

import eu.bopet.jocadv.core.constraints.regenerative.exception.NotOrthogonalVectorException;
import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.constraints.regenerative.axis.PointDirectionAxis;
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
    private final JoPlane referencePlane;
    private final JoPoint referencePoint;
    private final JoVector referenceDirection;

    private final JoAxis x;
    private final JoAxis y;
    private final JoAxis z;

    private final JoPlane xy;
    private final JoPlane yz;
    private final JoPlane xz;

    private final JoCoSys resultCoordinateSystem;

    public PlanePointDirectionCoordinateSystem(JoPlane referencePlane, JoPoint point, JoVector direction) throws Exception {
        this.referencePlane = referencePlane;
        this.referencePoint = point;
        this.referenceDirection = direction;

        double checkOrthogonality = referencePlane.getNormal().getVector3D().dotProduct(referenceDirection.getVector3D());
        if (checkOrthogonality > JoValue.DEFAULT_TOLERANCE)
            throw new NotOrthogonalVectorException(referencePlane.getNormal(), referenceDirection);
        PointDirectionAxis pointDirectionAxis1 = new PointDirectionAxis(point, this.referenceDirection);
        this.x = (JoAxis) pointDirectionAxis1.getResult();
        PointDirectionAxis pointDirectionAxis2 = new PointDirectionAxis(point, this.referencePlane.getNormal());
        this.z = (JoAxis) pointDirectionAxis2.getResult();
        CrossVector crossVector = new CrossVector(z.getDirection(), x.getDirection());
        PointDirectionAxis pointDirectionAxis3 = new PointDirectionAxis(point, (JoVector) crossVector.getResult());
        this.y = (JoAxis) pointDirectionAxis3.getResult();
        PointNormalPlane pointNormalPlane1 = new PointNormalPlane(referencePoint, this.z.getDirection());
        this.xy = (JoPlane) pointNormalPlane1.getResult();
        PointNormalPlane pointNormalPlane2 = new PointNormalPlane(referencePoint, this.x.getDirection());
        this.yz = (JoPlane) pointNormalPlane2.getResult();
        PointNormalPlane pointNormalPlane3 = new PointNormalPlane(referencePoint, this.y.getDirection());
        this.xz = (JoPlane) pointNormalPlane3.getResult();
        this.resultCoordinateSystem = new JoCoSys(referencePoint, x, y, z, xy, yz, xz, this);
    }

    @Override
    public void regenerate() throws Exception {
        if (referencePlane.getRegenerativeLink() != null) referencePlane.getRegenerativeLink().regenerate();
        if (referencePoint.getRegenerativeLink() != null) referencePoint.getRegenerativeLink().regenerate();
        if (referenceDirection.getRegenerativeLink() != null) referenceDirection.getRegenerativeLink().regenerate();
        double checkOrthogonality = referencePlane.getNormal().getVector3D().dotProduct(referenceDirection.getVector3D());
        if (checkOrthogonality > JoValue.DEFAULT_TOLERANCE)
            throw new NotOrthogonalVectorException(referencePlane.getNormal(), referenceDirection);
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
}
