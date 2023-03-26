package eu.bopet.jocadv.core.constraints.regenerative.axis;

import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoAxis;
import eu.bopet.jocadv.core.features.vector.JoVector;

import java.util.HashSet;
import java.util.Set;

public class PointDirectionAxis implements RegenerativeLink {
    private final JoAxis resultAxis;
    private JoPoint referencePoint;
    private JoVector referenceDirection;

    public PointDirectionAxis(JoPoint referencePoint, JoVector referenceDirection) {
        this.referencePoint = referencePoint;
        this.referenceDirection = referenceDirection;
        resultAxis = new JoAxis(referencePoint, referenceDirection, this);
    }

    public PointDirectionAxis(JoPoint referencePoint, JoVector referenceDirection, JoAxis resultAxis) throws Exception {
        this.referencePoint = referencePoint;
        this.referenceDirection = referenceDirection;
        this.resultAxis = resultAxis;
        regenerate();
    }

    public void setReferencePoint(JoPoint referencePoint) throws Exception {
        this.referencePoint = referencePoint;
        regenerate();
    }

    public void setReferenceDirection(JoVector referenceDirection) throws Exception {
        this.referenceDirection = referenceDirection;
        regenerate();
    }

    @Override
    public void regenerate() throws Exception {
        if (referencePoint.getRegenerativeLink() != null) referencePoint.getRegenerativeLink().regenerate();
        if (referenceDirection.getRegenerativeLink() != null) referenceDirection.getRegenerativeLink().regenerate();
        resultAxis.getPoint().getVector().getX().set(referencePoint.getVector().getX().get());
        resultAxis.getPoint().getVector().getY().set(referencePoint.getVector().getY().get());
        resultAxis.getPoint().getVector().getZ().set(referencePoint.getVector().getZ().get());
        resultAxis.getDirection().getX().set(referenceDirection.getX().get());
        resultAxis.getDirection().getY().set(referenceDirection.getY().get());
        resultAxis.getDirection().getZ().set(referenceDirection.getZ().get());
    }

    @Override
    public JoFeature getResult() {
        return resultAxis;
    }

    @Override
    public Set<JoValue> getValues() {
        Set<JoValue> result = new HashSet<>(referencePoint.getValues());
        result.addAll(referenceDirection.getValues());
        return result;
    }

    @Override
    public String toString() {
        return "PointDirectionAxis{" +
                "referencePoint=" + referencePoint +
                ", referenceDirection=" + referenceDirection +
                ", resultAxis=" + resultAxis +
                '}';
    }
}
