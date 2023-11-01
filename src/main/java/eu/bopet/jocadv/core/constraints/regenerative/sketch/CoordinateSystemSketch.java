package eu.bopet.jocadv.core.constraints.regenerative.sketch;

import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.sketch.JoSValue;
import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.datums.JoCoSys;
import eu.bopet.jocadv.core.features.sketch.JoSketch;

import java.util.HashSet;
import java.util.Set;

public class CoordinateSystemSketch implements RegenerativeLink {
    private final JoSketch resultSketch;
    private JoCoSys referenceCoordinateSystem;

    public CoordinateSystemSketch(JoCoSys referenceCoordinateSystem) {
        this.referenceCoordinateSystem = referenceCoordinateSystem;
        this.resultSketch = new JoSketch(referenceCoordinateSystem, this);
    }

    public CoordinateSystemSketch(JoCoSys referenceCoordinateSystem, JoSketch resultSketch) throws Exception {
        this.referenceCoordinateSystem = referenceCoordinateSystem;
        this.resultSketch = resultSketch;
        regenerate();
    }

    public void setReferenceCoordinateSystem(JoCoSys referenceCoordinateSystem) throws Exception {
        this.referenceCoordinateSystem = referenceCoordinateSystem;
        regenerate();
    }

    @Override
    public void regenerate() throws Exception {
        referenceCoordinateSystem.getRegenerativeLink().regenerate();
    }

    @Override
    public JoFeature getResult() {
        return resultSketch;
    }

    @Override
    public Set<JoSValue> getValues() {
        return new HashSet<>(referenceCoordinateSystem.getValues());
    }

    @Override
    public String toString() {
        return "CoordinateSystemSketch{" +
                "referenceCoordinateSystem=" + referenceCoordinateSystem +
                ", resultSketch=" + resultSketch +
                '}';
    }
}
