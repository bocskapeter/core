package eu.bopet.jocadv.core.constraints.regenerative.plane;

import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.JoValue;

import java.util.HashSet;
import java.util.Set;

public class OffsetPlane implements RegenerativeLink {
    private JoPlane referencePlane;
    private final JoValue offsetValue;
    private final JoPlane resultPlane;


    public OffsetPlane(JoPlane referencePlane, JoValue offsetValue) {
        this.referencePlane = referencePlane;
        this.offsetValue = offsetValue;
        this.resultPlane = new JoPlane(referencePlane.getX(), referencePlane.getY(), referencePlane.getZ(),
                new JoValue(JoValue.USER, referencePlane.getD().get() + offsetValue.get()), this);
    }

    public OffsetPlane(JoPlane referencePlane, JoValue offsetValue, JoPlane resultPlane) throws Exception {
        this.referencePlane = referencePlane;
        this.offsetValue = offsetValue;
        this.resultPlane = resultPlane;
        regenerate();
    }

    public void setReferencePlane(JoPlane referencePlane) throws Exception {
        this.referencePlane = referencePlane;
        regenerate();
    }

    @Override
    public void regenerate() throws Exception {
        if (referencePlane.getRegenerativeLink() != null) referencePlane.getRegenerativeLink().regenerate();
        resultPlane.getX().set(referencePlane.getX().get());
        resultPlane.getY().set(referencePlane.getY().get());
        resultPlane.getZ().set(referencePlane.getZ().get());
        resultPlane.getD().set(referencePlane.getD().get() + offsetValue.get());
    }

    @Override
    public JoFeature getResult() {
        return resultPlane;
    }

    @Override
    public Set<JoValue> getValues() {
        Set<JoValue> result = new HashSet<>(referencePlane.getValues());
        result.add(offsetValue);
        return result;
    }

    @Override
    public String toString() {
        return "OffsetPlane{" +
                "referencePlane=" + referencePlane +
                ", offsetValue=" + offsetValue +
                ", resultPlane=" + resultPlane +
                '}';
    }
}
