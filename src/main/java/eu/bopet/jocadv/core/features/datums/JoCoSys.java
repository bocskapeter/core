package eu.bopet.jocadv.core.features.datums;

import eu.bopet.jocadv.core.features.Base;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.Selectable;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

public class JoCoSys extends Base implements Selectable {
    public static final JoCoSys DEFAULT_COORDINATE_SYSTEM =
            new JoCoSys(JoPoint.ORIGIN,
                    JoAxis.X, JoAxis.Y, JoAxis.Z,
                    JoPlane.XY, JoPlane.YZ, JoPlane.XZ);

    private final JoPoint origin;
    private final JoAxis x;
    private final JoAxis y;
    private final JoAxis z;
    private final JoPlane xy;
    private final JoPlane yz;
    private final JoPlane xz;

    public JoCoSys(JoPoint origin, JoAxis x, JoAxis y, JoAxis z, JoPlane xy, JoPlane yz, JoPlane zx) {
        this.origin = origin;
        this.x = x;
        this.y = y;
        this.z = z;
        this.xy = xy;
        this.yz = yz;
        this.xz = zx;
    }

    public JoPoint getOrigin() {
        return origin;
    }

    public JoAxis getX() {
        return x;
    }

    public JoAxis getY() {
        return y;
    }

    public JoAxis getZ() {
        return z;
    }

    public JoPlane getXy() {
        return xy;
    }

    public JoPlane getYz() {
        return yz;
    }

    public JoPlane getXz() {
        return xz;
    }

    @Override
    public double distance(Line pickingLine) {
        return pickingLine.distance(origin.getVector().getVector3D());
    }

}
