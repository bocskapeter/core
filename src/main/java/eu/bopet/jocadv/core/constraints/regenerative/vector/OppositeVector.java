package eu.bopet.jocadv.core.constraints.regenerative.vector;

import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;

import java.util.HashSet;
import java.util.Set;

public class OppositeVector implements RegenerativeLink {
    private JoVector referenceVector;
    private final JoVector resultVector;

    public OppositeVector(JoVector referenceVector) {
        this.referenceVector = referenceVector;
        if (referenceVector.getRegenerativeLink() instanceof OppositeVector) {
            OppositeVector oppositeVector = (OppositeVector) referenceVector.getRegenerativeLink();
            this.resultVector = oppositeVector.getReferenceVector();
            return;
        }
        this.resultVector = new JoVector(
                new JoValue(JoValue.USER, -1.0 * referenceVector.getX().get()),
                new JoValue(JoValue.USER, -1.0 * referenceVector.getY().get()),
                new JoValue(JoValue.USER, -1.0 * referenceVector.getZ().get()), this);
    }

    public OppositeVector(JoVector referenceVector, JoVector resultVector) throws Exception {
        this.referenceVector = referenceVector;
        this.resultVector = resultVector;
        regenerate();
    }

    public void setReferenceVector(JoVector referenceVector) throws Exception {
        this.referenceVector = referenceVector;
        regenerate();
    }

    public JoVector getReferenceVector() {
        return referenceVector;
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
    public Set<JoValue> getValues() {
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
