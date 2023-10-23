package eu.bopet.jocadv.core.features.vector;

import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.Set;

public class JoVector implements JoFeature {
    public final static JoVector ZERO = new JoVector(JoValue.ZERO, JoValue.ZERO, JoValue.ZERO, null);
    public static final JoVector I = new JoVector(JoValue.ONE, JoValue.ZERO, JoValue.ZERO, null);
    public static final JoVector J = new JoVector(JoValue.ZERO, JoValue.ONE, JoValue.ZERO, null);
    public static final JoVector K = new JoVector(JoValue.ZERO, JoValue.ZERO, JoValue.ONE, null);
    private final JoValue x;
    private final JoValue y;
    private final JoValue z;
    private RegenerativeLink regenerativeLink;

    public JoVector(JoValue x, JoValue y, JoValue z, RegenerativeLink regenerativeLink) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.regenerativeLink = regenerativeLink;
    }

    public JoVector(short status, Vector3D vector3D) {
        JoValue x = new JoValue(status, vector3D.getX());
        JoValue y = new JoValue(status, vector3D.getY());
        JoValue z = new JoValue(status, vector3D.getZ());
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public JoVector(short status, JoPoint point1, JoPoint point2) {
        this(status, point1.getVector3D().subtract(point2.getVector3D()));
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

    public Vector3D getVector3D() {
        return new Vector3D(x.get(), y.get(), z.get());
    }

    public Vector3D getMainDirection() {
        if (Math.abs(getVector3D().getY()) >= Math.abs(getVector3D().getZ())) {
            if (Math.abs(getVector3D().getX()) >= Math.abs(getVector3D().getY())) {
                if (getVector3D().getX() > 0) {
                    return Vector3D.PLUS_I;
                }
                return Vector3D.MINUS_I;
            } else {
                if (getVector3D().getY() > 0) {
                    return Vector3D.PLUS_J;
                }
                return Vector3D.MINUS_J;
            }
        } else {
            if (Math.abs(getVector3D().getX()) >= Math.abs(getVector3D().getZ())) {
                if (getVector3D().getX() > 0) {
                    return Vector3D.PLUS_I;
                }
                return Vector3D.MINUS_I;
            } else {
                if (getVector3D().getZ() > 0) {
                    return Vector3D.PLUS_K;
                }
                return Vector3D.MINUS_K;
            }
        }
    }

    public Set<JoValue> getValues() {
        Set<JoValue> result = JoFeature.super.getValues();
        result.add(x);
        result.add(y);
        result.add(z);
        return result;
    }

    @Override
    public void store() {
        JoFeature.super.store();
        x.store();
        y.store();
        z.store();
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
    public String toString() {
        return "↗{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
