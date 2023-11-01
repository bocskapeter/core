package eu.bopet.jocadv.core.features.datums;

import eu.bopet.jocadv.core.features.JoBaseFeature;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.sketch.JoSValue;
import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.apache.commons.math3.geometry.euclidean.threed.Line;
import org.apache.commons.math3.geometry.euclidean.threed.Plane;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.Set;

public class JoPlane extends JoBaseFeature implements Selectable, JoFeature {
    public final static JoPlane XY = new JoPlane("XY", JoSValue.ZERO, JoSValue.ZERO, JoSValue.ONE, JoSValue.ZERO, null);
    public final static JoPlane XZ = new JoPlane("XZ", JoSValue.ZERO, JoSValue.ONE, JoSValue.ZERO, JoSValue.ZERO, null);
    public final static JoPlane YZ = new JoPlane("YZ", JoSValue.ONE, JoSValue.ZERO, JoSValue.ZERO, JoSValue.ZERO, null);
    private final JoSValue x;
    private final JoSValue y;
    private final JoSValue z;
    private final JoSValue d;
    private final JoVector normal;
    private RegenerativeLink regenerativeLink;

    public JoPlane(JoSValue x, JoSValue y, JoSValue z, JoSValue d, RegenerativeLink regenerativeLink) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.d = d;
        this.regenerativeLink = regenerativeLink;
        normal = new JoVector(x, y, z, null);
    }

    public JoPlane(double x, double y, double z, double d) {
        this.x = new JoSValue(x);
        this.y = new JoSValue(y);
        this.z = new JoSValue(z);
        this.d = new JoSValue(d);
        this.regenerativeLink = null;
        normal = new JoVector(this.x, this.y, this.z, null);
    }

    public JoPlane(String name, JoSValue x, JoSValue y, JoSValue z, JoSValue d, RegenerativeLink regenerativeLink) {
        super();
        super.setName(name);
        this.x = x;
        this.y = y;
        this.z = z;
        this.d = d;
        this.regenerativeLink = regenerativeLink;
        normal = new JoVector(x, y, z, null);
    }

    public JoPlane(short status, JoPoint point, JoVector normal) {
        this.x = normal.getX();
        this.y = normal.getY();
        this.z = normal.getZ();
        this.normal = normal;
        Plane planeOrigin = new Plane(Vector3D.ZERO, normal.getVector3D(), JoSValue.DEFAULT_TOLERANCE);
        Plane plane = new Plane(point.getVector3D(), normal.getVector3D(), JoSValue.DEFAULT_TOLERANCE);
        double d = planeOrigin.getOffset(plane);
        this.d = new JoSValue(status, d);
        this.regenerativeLink = null;
    }

    public JoSValue getX() {
        return x;
    }

    public JoSValue getY() {
        return y;
    }

    public JoSValue getZ() {
        return z;
    }

    public JoSValue getD() {
        return d;
    }

    public Plane getPlane() {
        return new Plane(new Vector3D(x.get() * d.get(), y.get() * d.get(), z.get() * d.get()),
                new Vector3D(x.get(), y.get(), z.get()),
                this.getTolerance());
    }

    public JoVector getNormal() {
        return normal;
    }

    @Override
    public boolean isOn(JoPoint point) {
        return getPlane().contains(point.getVector3D());
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
    public RegenerativeLink getRegenerativeLink() {
        return regenerativeLink;
    }

    @Override
    public void setRegenerativeLink(RegenerativeLink newRegenerativeLink) {
        this.regenerativeLink = newRegenerativeLink;
    }

    @Override
    public Set<JoSValue> getValues() {
        Set<JoSValue> result = JoFeature.super.getValues();
        result.add(x);
        result.add(y);
        result.add(z);
        result.add(d);
        return result;
    }

    @Override
    public void store() {
        JoFeature.super.store();
        x.store();
        y.store();
        z.store();
        d.store();
    }

    @Override
    public String toString() {
        String name = "□";
        if (this.getName() != null) name = this.getName();
        return name + "{x=" + x + ", y=" + y + ", z=" + z + ", d=" + d + '}';
    }
}
