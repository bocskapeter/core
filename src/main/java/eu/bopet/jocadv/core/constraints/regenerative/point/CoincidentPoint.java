package eu.bopet.jocadv.core.constraints.regenerative.point;

import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;

import java.util.HashSet;
import java.util.Set;

public class CoincidentPoint implements RegenerativeLink {
    private JoPoint referencePoint;
    private final JoPoint resultPoint;

    public CoincidentPoint(JoPoint referencePoint) {
        this.referencePoint = referencePoint;
        this.resultPoint = new JoPoint(new JoVector(
                new JoValue(JoValue.USER, referencePoint.getVector().getX().get()),
                new JoValue(JoValue.USER, referencePoint.getVector().getY().get()),
                new JoValue(JoValue.USER, referencePoint.getVector().getZ().get()), null),
                this);
    }

    public CoincidentPoint(JoPoint referencePoint, JoPoint resultPoint) throws Exception {
        this.referencePoint = referencePoint;
        this.resultPoint = resultPoint;
        regenerate();
    }

    public void setReferencePoint(JoPoint referencePoint) throws Exception {
        this.referencePoint = referencePoint;
        regenerate();
    }

    @Override
    public void regenerate() throws Exception {
        if (referencePoint.getRegenerativeLink() != null) referencePoint.getRegenerativeLink().regenerate();
        this.resultPoint.getVector().getX().set(referencePoint.getVector().getX().get());
        this.resultPoint.getVector().getY().set(referencePoint.getVector().getY().get());
        this.resultPoint.getVector().getZ().set(referencePoint.getVector().getZ().get());
    }

    @Override
    public JoFeature getResult() {
        return resultPoint;
    }

    @Override
    public Set<JoValue> getValues() {
        return new HashSet<>(referencePoint.getValues());
    }

    @Override
    public String toString() {
        return "CoincidentPoint{" +
                "referencePoint=" + referencePoint +
                ", resultPoint=" + resultPoint +
                '}';
    }
}
