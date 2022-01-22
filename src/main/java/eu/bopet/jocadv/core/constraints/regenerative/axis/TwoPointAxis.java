package eu.bopet.jocadv.core.constraints.regenerative.axis;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoAxis;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;

import java.util.Set;

public class TwoPointAxis implements RegenerativeLink {
    private JoPoint referencePoint1;
    private JoPoint referencePoint2;
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

    public void setReferencePoint1(JoPoint referencePoint1) throws Exception {
        this.referencePoint1 = referencePoint1;
        regenerate();
    }

    public void setReferencePoint2(JoPoint referencePoint2) throws Exception {
        this.referencePoint2 = referencePoint2;
        regenerate();
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
    public Set<JoValue> getValues() {
        Set<JoValue> result = referencePoint1.getValues();
        result.addAll(referencePoint2.getValues());
        return result;
    }

    @Override
    public String toString() {
        return "TwoPointAxis{" +
                "referencePoint1=" + referencePoint1 +
                ", referencePoint2=" + referencePoint2 +
                ", resultAxis=" + resultAxis +
                '}';
    }
}
