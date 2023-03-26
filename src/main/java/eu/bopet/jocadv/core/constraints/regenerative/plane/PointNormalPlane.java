package eu.bopet.jocadv.core.constraints.regenerative.plane;

import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.vector.JoVector;

import java.util.HashSet;
import java.util.Set;

public class PointNormalPlane implements RegenerativeLink {
    private final JoPlane resultPlane;
    private JoPoint referencePoint;
    private JoVector referenceNormal;

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

    public PointNormalPlane(JoPoint referencePoint, JoVector referenceNormal, JoPlane resultPlane) throws Exception {
        this.referencePoint = referencePoint;
        this.referenceNormal = referenceNormal;
        this.resultPlane = resultPlane;
        regenerate();
    }

    public void setReferencePoint(JoPoint referencePoint) throws Exception {
        this.referencePoint = referencePoint;
        regenerate();
    }

    public void setReferenceNormal(JoVector referenceNormal) throws Exception {
        this.referenceNormal = referenceNormal;
        regenerate();
    }

    private double getD() {
        return -1.0 * this.referenceNormal.getX().get() * this.referencePoint.getVector().getX().get() +
                -1.0 * this.referenceNormal.getY().get() * this.referencePoint.getVector().getY().get() +
                -1.0 * this.referenceNormal.getZ().get() * this.referencePoint.getVector().getZ().get();
    }


    @Override
    public void regenerate() throws Exception {
        if (referencePoint.getRegenerativeLink() != null) referencePoint.getRegenerativeLink().regenerate();
        if (referenceNormal.getRegenerativeLink() != null) referenceNormal.getRegenerativeLink().regenerate();
        resultPlane.getX().set(referenceNormal.getX().get());
        resultPlane.getY().set(referenceNormal.getY().get());
        resultPlane.getZ().set(referenceNormal.getZ().get());
        resultPlane.getD().set(getD());
    }

    @Override
    public JoFeature getResult() {
        return resultPlane;
    }

    @Override
    public Set<JoValue> getValues() {
        Set<JoValue> result = new HashSet<>(referencePoint.getValues());
        result.addAll(referenceNormal.getValues());
        return result;
    }

    @Override
    public String toString() {
        return "PointNormalPlane{" +
                "referencePoint=" + referencePoint +
                ", referenceNormal=" + referenceNormal +
                ", resultPlane=" + resultPlane +
                '}';
    }
}
