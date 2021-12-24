package eu.bopet.jocadv.core.features.datums;

import eu.bopet.jocadv.core.features.Base;
import eu.bopet.jocadv.core.features.Geometry;
import eu.bopet.jocadv.core.features.datums.vector.JoValue;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.ArrayList;
import java.util.List;

public class JoCoSys extends Base implements Geometry {
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

    @Override
    public double distance(Line pickingLine) {
        return pickingLine.distance(origin.getVector().getVector3D());
    }

    @Override
    public List<JoValue> getValues() {
        List<JoValue> result = new ArrayList<>();
        result.addAll(origin.getValues());
        result.addAll(x.getValues());
        result.addAll(y.getValues());
        result.addAll(z.getValues());
        result.addAll(xy.getValues());
        result.addAll(yz.getValues());
        result.addAll(xz.getValues());
        return result;
    }

    @Override
    public List<JoPoint> getPoints() {
        List<JoPoint> result = new ArrayList<>();
        result.add(origin);
        return result;
    }
}
