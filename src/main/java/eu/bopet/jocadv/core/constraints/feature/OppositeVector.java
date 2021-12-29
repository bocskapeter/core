package eu.bopet.jocadv.core.constraints.feature;

import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;

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
                new JoValue(-1.0 * referenceVector.getX().get()),
                new JoValue(-1.0 * referenceVector.getY().get()),
                new JoValue(-1.0 * referenceVector.getZ().get()), this);
    }

    public JoVector getReferenceVector() {
        return referenceVector;
    }

    @Override
    public void regenerate() {
        if (referenceVector.getRegenerativeLink() != null) referenceVector.getRegenerativeLink().regenerate();
        resultVector.getX().set(-1.0 * referenceVector.getX().get());
        resultVector.getX().set(-1.0 * referenceVector.getX().get());
        resultVector.getX().set(-1.0 * referenceVector.getX().get());
    }

    @Override
    public Feature getResult() {
        return resultVector;
    }
}
