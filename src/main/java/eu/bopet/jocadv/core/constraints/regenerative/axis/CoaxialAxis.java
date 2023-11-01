package eu.bopet.jocadv.core.constraints.regenerative.axis;

import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.sketch.JoSValue;
import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoAxis;
import eu.bopet.jocadv.core.features.vector.JoVector;

import java.util.HashSet;
import java.util.Set;

public class CoaxialAxis implements RegenerativeLink {
    private final JoAxis resultAxis;
    private JoAxis referenceAxis;

    public CoaxialAxis(JoAxis referenceAxis) {
        this.referenceAxis = referenceAxis;
        this.resultAxis = new JoAxis(
                new JoPoint(new JoVector(
                        new JoSValue(JoSValue.USER, referenceAxis.getPoint().getVector().getX().get()),
                        new JoSValue(JoSValue.USER, referenceAxis.getPoint().getVector().getY().get()),
                        new JoSValue(JoSValue.USER, referenceAxis.getPoint().getVector().getZ().get()), null),
                        null),
                new JoVector(
                        new JoSValue(JoSValue.USER, referenceAxis.getDirection().getX().get()),
                        new JoSValue(JoSValue.USER, referenceAxis.getDirection().getY().get()),
                        new JoSValue(JoSValue.USER, referenceAxis.getDirection().getZ().get()), null),
                this);
    }

    public CoaxialAxis(JoAxis referenceAxis, JoAxis resultAxis) throws Exception {
        this.referenceAxis = referenceAxis;
        this.resultAxis = resultAxis;
        regenerate();
    }

    public void setReferenceAxis(JoAxis referenceAxis) throws Exception {
        this.referenceAxis = referenceAxis;
        regenerate();
    }

    @Override
    public void regenerate() throws Exception {
        if (referenceAxis.getRegenerativeLink() != null) referenceAxis.getRegenerativeLink().regenerate();
        this.resultAxis.getPoint().getVector().getX().set(referenceAxis.getPoint().getVector().getX().get());
        this.resultAxis.getPoint().getVector().getY().set(referenceAxis.getPoint().getVector().getY().get());
        this.resultAxis.getPoint().getVector().getZ().set(referenceAxis.getPoint().getVector().getZ().get());
        this.resultAxis.getDirection().getX().set(referenceAxis.getDirection().getX().get());
        this.resultAxis.getDirection().getY().set(referenceAxis.getDirection().getY().get());
        this.resultAxis.getDirection().getZ().set(referenceAxis.getDirection().getZ().get());
    }

    @Override
    public JoFeature getResult() {
        return resultAxis;
    }

    @Override
    public Set<JoSValue> getValues() {
        return new HashSet<>(referenceAxis.getValues());
    }

    @Override
    public String toString() {
        return "CoaxialAxis{" +
                "referenceAxis=" + referenceAxis +
                ", resultAxis=" + resultAxis +
                '}';
    }
}
