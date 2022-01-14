package eu.bopet.jocadv.core.constraints.regenerative.point;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;

import java.util.Set;

public class CoincidentPoint implements RegenerativeLink {
    private final JoPoint referencePoint;
    private final JoPoint resultPoint;

    public CoincidentPoint(JoPoint referencePoint) {
        this.referencePoint = referencePoint;
        this.resultPoint = new JoPoint(new JoVector(
                new JoValue(JoValue.USER, referencePoint.getVector().getX().get()),
                new JoValue(JoValue.USER, referencePoint.getVector().getY().get()),
                new JoValue(JoValue.USER, referencePoint.getVector().getZ().get()), null),
                this);
    }

    @Override
    public void regenerate() throws Exception {
        if (referencePoint.getRegenerativeLink() != null) referencePoint.getRegenerativeLink().regenerate();
        this.resultPoint.getVector().getX().set(referencePoint.getVector().getX().get());
        this.resultPoint.getVector().getY().set(referencePoint.getVector().getY().get());
        this.resultPoint.getVector().getZ().set(referencePoint.getVector().getZ().get());
    }

    @Override
    public Feature getResult() {
        return resultPoint;
    }

    @Override
    public Set<JoValue> getValues() {
        return referencePoint.getValues();
    }
}
