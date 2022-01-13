package eu.bopet.jocadv.core.constraints.regenerative.vector;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.constraints.regenerative.ParallelVectorException;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.List;

public class CrossVector implements RegenerativeLink {
    private final JoVector referenceVector1;
    private final JoVector referenceVector2;
    private final JoVector resultVector;

    public CrossVector(JoVector referenceVector1, JoVector referenceVector2) throws ParallelVectorException {
        this.referenceVector1 = referenceVector1;
        this.referenceVector2 = referenceVector2;
        Vector3D vector3D = referenceVector1.getVector3D().crossProduct(referenceVector2.getVector3D());
        if (vector3D.getNormSq()<JoValue.DEFAULT_TOLERANCE) throw new ParallelVectorException(referenceVector1,referenceVector2);
        resultVector = new JoVector(
                new JoValue(JoValue.USER, vector3D.getX()),
                new JoValue(JoValue.USER, vector3D.getY()),
                new JoValue(JoValue.USER, vector3D.getZ()),
                this
        );
    }

    @Override
    public void regenerate() throws Exception {
        if (referenceVector1.getRegenerativeLink() != null) referenceVector1.getRegenerativeLink().regenerate();
        if (referenceVector2.getRegenerativeLink() != null) referenceVector2.getRegenerativeLink().regenerate();
        Vector3D vector3D = referenceVector1.getVector3D().crossProduct(referenceVector2.getVector3D());
        resultVector.getX().set(vector3D.getX());
        resultVector.getY().set(vector3D.getY());
        resultVector.getZ().set(vector3D.getZ());
    }

    @Override
    public Feature getResult() {
        return resultVector;
    }

    @Override
    public List<JoValue> getValues() {
        return null;
    }
}
