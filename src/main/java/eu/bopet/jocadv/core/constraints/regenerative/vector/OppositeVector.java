package eu.bopet.jocadv.core.constraints.regenerative.vector;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;

import java.util.Set;

public class OppositeVector implements RegenerativeLink {
    private final JoVector referenceVector;
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
    public Feature getResult() {
        return resultVector;
    }

    @Override
    public Set<JoValue> getValues() {
        return referenceVector.getValues();
    }
}
