package eu.bopet.jocadv.core.constraints.feature;

import eu.bopet.jocadv.core.features.datums.JoAxis;
import eu.bopet.jocadv.core.features.datums.JoPoint;
import eu.bopet.jocadv.core.features.datums.vector.JoValue;
import eu.bopet.jocadv.core.features.datums.vector.JoVector;

public class TwoPointAxis implements Regenerative {
    private final JoPoint point1;
    private final JoPoint point2;
    private final JoAxis resultAxis;

    public TwoPointAxis(JoPoint point1, JoPoint point2) {
        this.point1 = point1;
        this.point2 = point2;
        this.resultAxis = new JoAxis(
                new JoPoint(new JoVector(
                        new JoValue(point1.getVector().getX().get()),
                        new JoValue(point1.getVector().getY().get()),
                        new JoValue(point1.getVector().getZ().get()))),
                new JoVector(
                        new JoValue(point2.getVector().getX().get() - point1.getVector().getX().get()),
                        new JoValue(point2.getVector().getY().get() - point1.getVector().getY().get()),
                        new JoValue(point2.getVector().getZ().get() - point1.getVector().getZ().get())
                ));
    }

    @Override
    public void regenerate() {
        this.resultAxis.getPoint().getVector().getX().set(point1.getVector().getX().get());
        this.resultAxis.getPoint().getVector().getY().set(point1.getVector().getY().get());
        this.resultAxis.getPoint().getVector().getZ().set(point1.getVector().getZ().get());
        this.resultAxis.getDirection().getX().set(point2.getVector().getX().get() - point1.getVector().getX().get());
        this.resultAxis.getDirection().getY().set(point2.getVector().getY().get() - point1.getVector().getY().get());
        this.resultAxis.getDirection().getZ().set(point2.getVector().getZ().get() - point1.getVector().getZ().get());
    }
}
