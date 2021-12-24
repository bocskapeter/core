package eu.bopet.jocadv.core.constraints.feature;

import eu.bopet.jocadv.core.features.datums.JoPoint;
import eu.bopet.jocadv.core.features.datums.vector.JoValue;
import eu.bopet.jocadv.core.features.datums.vector.JoVector;

public class CoincidentPoint implements Regenerative {
    private final JoPoint referencePoint;
    private final JoPoint resultPoint;

    public CoincidentPoint(JoPoint referencePoint) {
        this.referencePoint = referencePoint;
        this.resultPoint = new JoPoint(new JoVector(
                new JoValue(referencePoint.getVector().getX().get()),
                new JoValue(referencePoint.getVector().getY().get()),
                new JoValue(referencePoint.getVector().getZ().get())
        ));
    }

    @Override
    public void regenerate() {
        this.resultPoint.getVector().getX().set(referencePoint.getVector().getX().get());
        this.resultPoint.getVector().getY().set(referencePoint.getVector().getY().get());
        this.resultPoint.getVector().getZ().set(referencePoint.getVector().getZ().get());
    }
}
