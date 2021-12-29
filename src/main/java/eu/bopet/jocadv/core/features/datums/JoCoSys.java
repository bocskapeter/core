package eu.bopet.jocadv.core.features.datums;

import eu.bopet.jocadv.core.constraints.feature.RegenerativeLink;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.FeatureBase;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.Selectable;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

public class JoCoSys extends FeatureBase implements Selectable, Feature {
    public static final JoCoSys DEFAULT_COORDINATE_SYSTEM =
            new JoCoSys(JoPoint.ORIGIN,
                    JoAxis.X, JoAxis.Y, JoAxis.Z,
                    JoPlane.XY, JoPlane.YZ, JoPlane.XZ, null);

    private final JoPoint origin;
    private final JoAxis x;
    private final JoAxis y;
    private final JoAxis z;
    private final JoPlane xy;
    private final JoPlane yz;
    private final JoPlane xz;
    private final RegenerativeLink regenerative;

    public JoCoSys(JoPoint origin, JoAxis x, JoAxis y, JoAxis z, JoPlane xy, JoPlane yz, JoPlane xz, RegenerativeLink regenerative) {
        this.origin = origin;
        this.x = x;
        this.y = y;
        this.z = z;
        this.xy = xy;
        this.yz = yz;
        this.xz = xz;
        this.regenerative = regenerative;
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

    @Override
    public RegenerativeLink getRegenerativeLink() {
        return regenerative;
    }
}
