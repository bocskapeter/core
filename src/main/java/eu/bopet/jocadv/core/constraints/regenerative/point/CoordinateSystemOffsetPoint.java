package eu.bopet.jocadv.core.constraints.regenerative.point;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoCoSys;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.HashSet;
import java.util.Set;

public class CoordinateSystemOffsetPoint implements RegenerativeLink {
    private JoCoSys referenceCoordinateSystem;
    private final JoValue x;
    private final JoValue y;
    private final JoValue z;
    private final JoPoint resultPoint;

    public CoordinateSystemOffsetPoint(JoCoSys referenceCoordinateSystem, JoValue x, JoValue y, JoValue z) {
        this.referenceCoordinateSystem = referenceCoordinateSystem;
        this.x = x;
        this.y = y;
        this.z = z;
        Vector3D origin = referenceCoordinateSystem.getOrigin().getVector().getVector3D();
        Vector3D vectorX =
                referenceCoordinateSystem.getX().getDirection().getVector3D().normalize().scalarMultiply(x.get());
        Vector3D vectorY =
                referenceCoordinateSystem.getY().getDirection().getVector3D().normalize().scalarMultiply(y.get());
        Vector3D vectorZ =
                referenceCoordinateSystem.getZ().getDirection().getVector3D().normalize().scalarMultiply(z.get());
        Vector3D vector3D = (vectorX.add(vectorY)).add(vectorZ);
        Vector3D newPoint = origin.add(vector3D);
        JoValue newX = new JoValue(JoValue.USER, newPoint.getX());
        JoValue newY = new JoValue(JoValue.USER, newPoint.getY());
        JoValue newZ = new JoValue(JoValue.USER, newPoint.getZ());
        JoVector joVector = new JoVector(newX, newY, newZ, null);
        this.resultPoint = new JoPoint(joVector, this);
    }

    public CoordinateSystemOffsetPoint(JoCoSys referenceCoordinateSystem,
                                       JoValue x, JoValue y, JoValue z, JoPoint resultPoint) throws Exception {
        this.referenceCoordinateSystem = referenceCoordinateSystem;
        this.x = x;
        this.y = y;
        this.z = z;
        this.resultPoint = resultPoint;
        regenerate();
    }

    public void setReferenceCoordinateSystem(JoCoSys referenceCoordinateSystem) throws Exception {
        this.referenceCoordinateSystem = referenceCoordinateSystem;
        regenerate();
    }

    @Override
    public void regenerate() throws Exception {
        if (referenceCoordinateSystem.getRegenerativeLink() != null)
            referenceCoordinateSystem.getRegenerativeLink().regenerate();
        Vector3D origin = referenceCoordinateSystem.getOrigin().getVector().getVector3D();
        Vector3D vectorX =
                referenceCoordinateSystem.getX().getDirection().getVector3D().normalize().scalarMultiply(x.get());
        Vector3D vectorY =
                referenceCoordinateSystem.getY().getDirection().getVector3D().normalize().scalarMultiply(y.get());
        Vector3D vectorZ =
                referenceCoordinateSystem.getZ().getDirection().getVector3D().normalize().scalarMultiply(z.get());
        Vector3D vector3D = (vectorX.add(vectorY)).add(vectorZ);
        Vector3D newPoint = origin.add(vector3D);
        resultPoint.getVector().getX().set(newPoint.getX());
        resultPoint.getVector().getY().set(newPoint.getY());
        resultPoint.getVector().getZ().set(newPoint.getZ());
    }

    @Override
    public Feature getResult() {
        return resultPoint;
    }

    @Override
    public Set<JoValue> getValues() {
        Set<JoValue> result = new HashSet<>(referenceCoordinateSystem.getValues());
        result.add(x);
        result.add(y);
        result.add(z);
        return result;
    }

    @Override
    public String toString() {
        return "CoordinateSystemOffsetPoint{" +
                "referenceCoordinateSystem=" + referenceCoordinateSystem +
                ", resultPoint=" + resultPoint +
                '}';
    }
}
