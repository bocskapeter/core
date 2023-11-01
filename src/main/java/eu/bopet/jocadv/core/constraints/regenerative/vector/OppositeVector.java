package eu.bopet.jocadv.core.constraints.regenerative.vector;

import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.sketch.JoSValue;
import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.vector.JoVector;

import java.util.HashSet;
import java.util.Set;

public class OppositeVector implements RegenerativeLink {
    private final JoVector resultVector;
    private JoVector referenceVector;

    public OppositeVector(JoVector referenceVector) {
        this.referenceVector = referenceVector;
        if (referenceVector.getRegenerativeLink() instanceof OppositeVector) {
            OppositeVector oppositeVector = (OppositeVector) referenceVector.getRegenerativeLink();
            this.resultVector = oppositeVector.getReferenceVector();
            return;
        }
        this.resultVector = new JoVector(
                new JoSValue(JoSValue.USER, -1.0 * referenceVector.getX().get()),
                new JoSValue(JoSValue.USER, -1.0 * referenceVector.getY().get()),
                new JoSValue(JoSValue.USER, -1.0 * referenceVector.getZ().get()), this);
    }

    public OppositeVector(JoVector referenceVector, JoVector resultVector) throws Exception {
        this.referenceVector = referenceVector;
        this.resultVector = resultVector;
        regenerate();
    }

    public JoVector getReferenceVector() {
        return referenceVector;
    }

    public void setReferenceVector(JoVector referenceVector) throws Exception {
        this.referenceVector = referenceVector;
        regenerate();
    }

    @Override
    public void regenerate() throws Exception {
        if (referenceVector.getRegenerativeLink() != null) referenceVector.getRegenerativeLink().regenerate();
        resultVector.getX().set(-1.0 * referenceVector.getX().get());
        resultVector.getX().set(-1.0 * referenceVector.getX().get());
        resultVector.getX().set(-1.0 * referenceVector.getX().get());
    }

    @Override
    public JoFeature getResult() {
        return resultVector;
    }

    @Override
    public Set<JoSValue> getValues() {
        return new HashSet<>(referenceVector.getValues());
    }

    @Override
    public String toString() {
        return "OppositeVector{" +
                "referenceVector=" + referenceVector +
                ", resultVector=" + resultVector +
                '}';
    }
}
