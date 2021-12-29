package eu.bopet.jocadv.core.constraints.feature;

import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoAxis;
import eu.bopet.jocadv.core.features.datums.JoCoSys;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;

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

    public PlanePointDirectionCoordinateSystem(JoPlane referencePlane, JoPoint point, JoVector direction) {
        this.referencePlane = referencePlane;
        this.referencePoint = point;
        this.referenceDirection = direction;

        PointDirectionAxis pointDirectionAxis1 = new PointDirectionAxis(point, this.referenceDirection);
        this.x = (JoAxis) pointDirectionAxis1.getResult();
        PointDirectionAxis pointDirectionAxis2 = new PointDirectionAxis(point, this.referencePlane.getNormal());
        this.z = (JoAxis) pointDirectionAxis2.getResult();
        CrossVector crossVector = new CrossVector(z.getDirection(), x.getDirection());
        PointDirectionAxis pointDirectionAxis3 = new PointDirectionAxis(point, (JoVector) crossVector.getResult());
        this.y = (JoAxis) pointDirectionAxis3.getResult();
        this.xy = new JoPlane(JoValue.ONE, JoValue.ONE, JoValue.ONE, JoValue.ONE, null);
        this.yz = new JoPlane(JoValue.ONE, JoValue.ONE, JoValue.ONE, JoValue.ONE, null);
        this.xz = new JoPlane(JoValue.ONE, JoValue.ONE, JoValue.ONE, JoValue.ONE, null);
        this.resultCoordinateSystem = new JoCoSys(referencePoint, x, y, z, xy, yz, xz, this);
    }

    @Override
    public void regenerate() {
        x.getRegenerativeLink().regenerate();
        z.getRegenerativeLink().regenerate();
        y.getRegenerativeLink().regenerate();


    }

    @Override
    public Feature getResult() {
        return resultCoordinateSystem;
    }
}
