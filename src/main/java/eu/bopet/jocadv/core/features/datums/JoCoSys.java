package eu.bopet.jocadv.core.features.datums;

import eu.bopet.jocadv.core.features.JoBaseFeature;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.sketch.JoSValue;
import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.exception.ParallelVectorException;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.apache.commons.math3.geometry.euclidean.threed.Line;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.Set;

public class JoCoSys extends JoBaseFeature implements Selectable, JoFeature {
    public static final JoCoSys DEFAULT_COORDINATE_SYSTEM =
            new JoCoSys("Default", JoPoint.ORIGIN,
                    JoAxis.X, JoAxis.Y, JoAxis.Z,
                    JoPlane.XY, JoPlane.YZ, JoPlane.XZ, null);

    private final JoPoint origin;
    private final JoAxis x;
    private final JoAxis y;
    private final JoAxis z;
    private final JoPlane xy;
    private final JoPlane yz;
    private final JoPlane xz;
    private RegenerativeLink regenerativeLink;

    public JoCoSys(JoPoint origin, JoAxis x, JoAxis y, JoAxis z, JoPlane xy, JoPlane yz, JoPlane xz,
                   RegenerativeLink regenerativeLink) {
        this.origin = origin;
        this.x = x;
        this.y = y;
        this.z = z;
        this.xy = xy;
        this.yz = yz;
        this.xz = xz;
        this.regenerativeLink = regenerativeLink;
    }

    public JoCoSys(String name, JoPoint origin, JoAxis x, JoAxis y, JoAxis z, JoPlane xy, JoPlane yz, JoPlane xz,
                   RegenerativeLink regenerativeLink) {
        super();
        super.setName(name);
        this.origin = origin;
        this.x = x;
        this.y = y;
        this.z = z;
        this.xy = xy;
        this.yz = yz;
        this.xz = xz;
        this.regenerativeLink = regenerativeLink;
    }

    public JoCoSys(short status, JoPoint origin, JoVector x, JoVector y) throws ParallelVectorException {
        double crossProduct = x.getVector3D().crossProduct(y.getVector3D()).distanceSq(Vector3D.ZERO);
        if (Math.abs(crossProduct) < JoSValue.DEFAULT_TOLERANCE) {
            throw new ParallelVectorException(x, y);
        }
        this.origin = origin;
        this.x = new JoAxis(origin, x, null);
        Vector3D vector3DZ = x.getVector3D().crossProduct(y.getVector3D());
        JoVector joVectorZ = new JoVector(status, vector3DZ);
        this.z = new JoAxis(origin, joVectorZ, null);
        Vector3D vector3DY = vector3DZ.crossProduct(x.getVector3D());
        JoVector joVectorY = new JoVector(status, vector3DY);
        this.y = new JoAxis(origin, joVectorY, null);
        this.xy = new JoPlane(status, origin, z.getDirection());
        this.xz = new JoPlane(status, origin, this.y.getDirection());
        this.yz = new JoPlane(status, origin, this.x.getDirection());
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
        return regenerativeLink;
    }

    @Override
    public void setRegenerativeLink(RegenerativeLink newRegenerativeLink) {
        this.regenerativeLink = newRegenerativeLink;
    }

    public Set<JoSValue> getValues() {
        Set<JoSValue> result = JoFeature.super.getValues();
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
    public void store() {
        JoFeature.super.store();
        origin.store();
        x.store();
        y.store();
        z.store();
        xy.store();
        yz.store();
        xz.store();
    }

    @Override
    public String toString() {
        String name = "⟀";
        if (this.getName() != null) name = this.getName();
        return name + "{" +
                "origin=" + origin +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", xy=" + xy +
                ", yz=" + yz +
                ", xz=" + xz +
                '}';
    }

    @Override
    public boolean isOn(JoPoint point) {
        return origin.isOn(point);
    }
}
