package eu.bopet.jocadv.core.constraints.feature;

import eu.bopet.jocadv.core.features.datums.JoAxis;
import eu.bopet.jocadv.core.features.datums.JoPoint;
import eu.bopet.jocadv.core.features.datums.vector.JoValue;
import eu.bopet.jocadv.core.features.datums.vector.JoVector;

public class CoaxialAxis implements Regenerative {
    private final JoAxis referenceAxis;
    private final JoAxis resultAxis;

    public CoaxialAxis(JoAxis referenceAxis) {
        this.referenceAxis = referenceAxis;
        this.resultAxis = new JoAxis(new JoPoint(new JoVector(
                new JoValue(referenceAxis.getPoint().getVector().getX().get()),
                new JoValue(referenceAxis.getPoint().getVector().getY().get()),
                new JoValue(referenceAxis.getPoint().getVector().getZ().get()))),
                new JoVector(
                        new JoValue(referenceAxis.getDirection().getX().get()),
                        new JoValue(referenceAxis.getDirection().getY().get()),
                        new JoValue(referenceAxis.getDirection().getZ().get())
                ));
    }

    @Override
    public void regenerate() {
        this.resultAxis.getPoint().getVector().getX().set(referenceAxis.getPoint().getVector().getX().get());
        this.resultAxis.getPoint().getVector().getY().set(referenceAxis.getPoint().getVector().getY().get());
        this.resultAxis.getPoint().getVector().getZ().set(referenceAxis.getPoint().getVector().getZ().get());
        this.resultAxis.getDirection().getX().set(referenceAxis.getDirection().getX().get());
        this.resultAxis.getDirection().getY().set(referenceAxis.getDirection().getY().get());
        this.resultAxis.getDirection().getZ().set(referenceAxis.getDirection().getZ().get());
    }
}
