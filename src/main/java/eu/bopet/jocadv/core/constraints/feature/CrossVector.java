package eu.bopet.jocadv.core.constraints.feature;

import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

public class CrossVector implements RegenerativeLink {
    private final JoVector referenceVector1;
    private final JoVector referenceVector2;
    private final JoVector resultVector;

    public CrossVector(JoVector referenceVector1, JoVector referenceVector2) {
        this.referenceVector1 = referenceVector1;
        this.referenceVector2 = referenceVector2;
        Vector3D vector3D = referenceVector1.getVector3D().crossProduct(referenceVector2.getVector3D());
        resultVector = new JoVector(
                new JoValue(vector3D.getX()),
                new JoValue(vector3D.getY()),
                new JoValue(vector3D.getZ()),
                null
        );
    }

    @Override
    public void regenerate() {
        Vector3D vector3D = referenceVector1.getVector3D().crossProduct(referenceVector2.getVector3D());
        resultVector.getX().set(vector3D.getX());
        resultVector.getY().set(vector3D.getY());
        resultVector.getZ().set(vector3D.getZ());
    }

    @Override
    public Feature getResult() {
        return resultVector;
    }
}
