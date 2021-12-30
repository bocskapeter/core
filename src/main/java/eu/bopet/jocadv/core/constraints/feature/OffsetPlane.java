package eu.bopet.jocadv.core.constraints.feature;

import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.vector.JoValue;

public class OffsetPlane implements RegenerativeLink {
    private final JoPlane referencePlane;
    private final JoValue offsetValue;
    private final JoPlane resultPlane;


    public OffsetPlane(JoPlane referencePlane, JoValue offsetValue) {
        this.referencePlane = referencePlane;
        this.offsetValue = offsetValue;
        this.resultPlane = new JoPlane(referencePlane.getX(), referencePlane.getY(), referencePlane.getZ(),
                new JoValue(JoValue.USER, referencePlane.getD().get() + offsetValue.get()), this);
    }

    @Override
    public void regenerate() {
        if (referencePlane.getRegenerativeLink() != null) referencePlane.getRegenerativeLink().regenerate();
        resultPlane.getX().set(referencePlane.getX().get());
        resultPlane.getY().set(referencePlane.getY().get());
        resultPlane.getZ().set(referencePlane.getZ().get());
        resultPlane.getD().set(referencePlane.getD().get() + offsetValue.get());
    }

    @Override
    public Feature getResult() {
        return resultPlane;
    }
}
