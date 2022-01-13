package eu.bopet.jocadv.core.constraints.regenerative.axis;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoAxis;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;

import java.util.List;

public class TwoPointAxis implements RegenerativeLink {
    private final JoPoint referencePoint1;
    private final JoPoint referencePoint2;
    private final JoAxis resultAxis;

    public TwoPointAxis(JoPoint point1, JoPoint point2) {
        this.referencePoint1 = point1;
        this.referencePoint2 = point2;
        this.resultAxis = new JoAxis(
                new JoPoint(new JoVector(
                        new JoValue(JoValue.USER, point1.getVector().getX().get()),
                        new JoValue(JoValue.USER, point1.getVector().getY().get()),
                        new JoValue(JoValue.USER, point1.getVector().getZ().get()), null),
                        null),
                new JoVector(
                        new JoValue(
                                JoValue.USER, point2.getVector().getX().get() - point1.getVector().getX().get()),
                        new JoValue(
                                JoValue.USER, point2.getVector().getY().get() - point1.getVector().getY().get()),
                        new JoValue(
                                JoValue.USER, point2.getVector().getZ().get() - point1.getVector().getZ().get()),
                        null),
                this);
    }

    @Override
    public void regenerate() throws Exception {
        if (referencePoint1.getRegenerativeLink() != null) referencePoint1.getRegenerativeLink().regenerate();
        if (referencePoint2.getRegenerativeLink() != null) referencePoint2.getRegenerativeLink().regenerate();
        this.resultAxis.getPoint().getVector().getX().set(referencePoint1.getVector().getX().get());
        this.resultAxis.getPoint().getVector().getY().set(referencePoint1.getVector().getY().get());
        this.resultAxis.getPoint().getVector().getZ().set(referencePoint1.getVector().getZ().get());
        this.resultAxis.getDirection().getX().set(
                referencePoint2.getVector().getX().get() - referencePoint1.getVector().getX().get());
        this.resultAxis.getDirection().getY().set(
                referencePoint2.getVector().getY().get() - referencePoint1.getVector().getY().get());
        this.resultAxis.getDirection().getZ().set(
                referencePoint2.getVector().getZ().get() - referencePoint1.getVector().getZ().get());
    }

    @Override
    public Feature getResult() {
        return resultAxis;
    }

    @Override
    public List<JoValue> getValues() {
        return null;
    }
}
