package eu.bopet.jocadv.core.features.datums;

import eu.bopet.jocadv.core.features.FeatureBase;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.apache.commons.math3.geometry.euclidean.threed.Line;
import org.apache.commons.math3.geometry.euclidean.threed.Plane;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.Set;

public class JoPlane extends FeatureBase implements Selectable, JoFeature {
    public final static JoPlane XY = new JoPlane("XY", JoValue.ZERO, JoValue.ZERO, JoValue.ONE, JoValue.ZERO, null);
    public final static JoPlane XZ = new JoPlane("XZ", JoValue.ZERO, JoValue.ONE, JoValue.ZERO, JoValue.ZERO, null);
    public final static JoPlane YZ = new JoPlane("YZ", JoValue.ONE, JoValue.ZERO, JoValue.ZERO, JoValue.ZERO, null);
    private final JoValue x;
    private final JoValue y;
    private final JoValue z;
    private final JoValue d;
    private final JoVector normal;
    private RegenerativeLink regenerativeLink;

    public JoPlane(JoValue x, JoValue y, JoValue z, JoValue d, RegenerativeLink regenerativeLink) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.d = d;
        this.regenerativeLink = regenerativeLink;
        normal = new JoVector(x, y, z, null);
    }

    public JoPlane(double x, double y, double z, double d) {
        this.x = new JoValue(x);
        this.y = new JoValue(y);
        this.z = new JoValue(z);
        this.d = new JoValue(d);
        this.regenerativeLink = null;
        normal = new JoVector(this.x, this.y, this.z, null);
    }

    public JoPlane(String name, JoValue x, JoValue y, JoValue z, JoValue d, RegenerativeLink regenerativeLink) {
        super();
        super.setName(name);
        this.x = x;
        this.y = y;
        this.z = z;
        this.d = d;
        this.regenerativeLink = regenerativeLink;
        normal = new JoVector(x, y, z, null);
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
    public Set<JoValue> getValues() {
        Set<JoValue> result = JoFeature.super.getValues();
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
