package eu.bopet.jocadv.core.constraints.feature;

import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;

public class PointNormalPlane implements RegenerativeLink {
    private final JoPoint referencePoint;
    private final JoVector referenceNormal;
    private final JoPlane resultPlane;

    public PointNormalPlane(JoPoint referencePoint, JoVector referenceNormal) {
        this.referencePoint = referencePoint;
        this.referenceNormal = referenceNormal;
        this.resultPlane = new JoPlane(
                new JoValue(JoValue.USER, this.referenceNormal.getX().get()),
                new JoValue(JoValue.USER, this.referenceNormal.getY().get()),
                new JoValue(JoValue.USER, this.referenceNormal.getZ().get()),
                new JoValue(JoValue.USER, getD()),
                this
        );
    }

    private double getD() {
        return -1.0 * this.referenceNormal.getX().get() * this.referencePoint.getVector().getX().get() +
                -1.0 * this.referenceNormal.getY().get() * this.referencePoint.getVector().getY().get() +
                -1.0 * this.referenceNormal.getZ().get() * this.referencePoint.getVector().getZ().get();
    }


    @Override
    public void regenerate() {
        if (referencePoint.getRegenerativeLink() != null) referencePoint.getRegenerativeLink().regenerate();
        if (referenceNormal.getRegenerativeLink() != null) referenceNormal.getRegenerativeLink().regenerate();
        resultPlane.getX().set(referenceNormal.getX().get());
        resultPlane.getY().set(referenceNormal.getY().get());
        resultPlane.getZ().set(referenceNormal.getZ().get());
        resultPlane.getD().set(getD());
    }

    @Override
    public Feature getResult() {
        return resultPlane;
    }
}
