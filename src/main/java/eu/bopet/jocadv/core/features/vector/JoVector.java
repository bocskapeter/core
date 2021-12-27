package eu.bopet.jocadv.core.features.vector;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.ArrayList;
import java.util.List;

public class JoVector {
    public final static JoVector ZERO = new JoVector(JoValue.ZERO, JoValue.ZERO, JoValue.ZERO);
    public static final JoVector I = new JoVector(JoValue.ONE, JoValue.ZERO, JoValue.ZERO);
    public static final JoVector J = new JoVector(JoValue.ZERO, JoValue.ONE, JoValue.ZERO);
    public static final JoVector K = new JoVector(JoValue.ZERO, JoValue.ZERO, JoValue.ONE);
    private final JoValue x;
    private final JoValue y;
    private final JoValue z;

    public JoVector(JoValue x, JoValue y, JoValue z) {
        this.x = x;
        this.y = y;
        this.z = z;
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

    public List<JoValue> getValues() {
        List<JoValue> result = new ArrayList<>();
        result.add(x);
        result.add(y);
        result.add(z);
        return result;
    }
}
