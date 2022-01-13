package eu.bopet.jocadv.core.constraints.regenerative.axis;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoAxis;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;

import java.util.List;

public class PointDirectionAxis implements RegenerativeLink {
    private final JoPoint referencePoint;
    private final JoVector referenceDirection;
    private final JoAxis resultAxis;

    public PointDirectionAxis(JoPoint referencePoint, JoVector referenceDirection) {
        this.referencePoint = referencePoint;
        this.referenceDirection = referenceDirection;
        resultAxis = new JoAxis(referencePoint, referenceDirection, this);
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
    public Feature getResult() {
        return resultAxis;
    }

    @Override
    public List<JoValue> getValues() {
        return null;
    }
}
