package eu.bopet.jocadv.core.features.datums;

import eu.bopet.jocadv.core.features.Base;
import eu.bopet.jocadv.core.features.Geometry;
import eu.bopet.jocadv.core.features.datums.vector.JoValue;
import org.apache.commons.math3.geometry.euclidean.threed.Line;
import org.apache.commons.math3.geometry.euclidean.threed.Plane;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.ArrayList;
import java.util.List;

public class JoPlane extends Base implements Geometry {
    public final static JoPlane XY = new JoPlane(JoValue.ZERO, JoValue.ZERO, JoValue.ONE, JoValue.ZERO);
    public final static JoPlane XZ = new JoPlane(JoValue.ZERO, JoValue.ONE, JoValue.ZERO, JoValue.ZERO);
    public final static JoPlane YZ = new JoPlane(JoValue.ONE, JoValue.ZERO, JoValue.ZERO, JoValue.ZERO);
    private final JoValue x;
    private final JoValue y;
    private final JoValue z;
    private final JoValue d;

    public JoPlane(JoValue x, JoValue y, JoValue z, JoValue d) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.d = d;
    }

    public JoValue getX() {
        return x;
    }

    public JoValue getY() {
        return y;
    }

    public JoValue getZ() {
        return z;
    }

    public JoValue getD() {
        return d;
    }

    public Plane getPlane() {
        return new Plane(new Vector3D(x.get() * d.get(), y.get() * d.get(), z.get() * d.get()),
                new Vector3D(x.get(), y.get(), z.get()),
                JoValue.DEFAULT_TOLERANCE);
    }

    @Override
    public double distance(Line pickingLine) {
        Plane thisPlane = getPlane();
        Vector3D intersection = thisPlane.intersection(pickingLine);
        if (intersection == null) {
            return thisPlane.getOffset(pickingLine.getOrigin());
        }
        return pickingLine.distance(intersection);
    }

    @Override
    public List<JoValue> getValues() {
        List<JoValue> result = new ArrayList<>();
        result.add(x);
        result.add(y);
        result.add(z);
        return result;
    }

    @Override
    public List<JoPoint> getPoints() {
        List<JoPoint> result = new ArrayList<>();
        return result;
    }
}
