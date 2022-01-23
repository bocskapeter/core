package eu.bopet.jocadv.core.constraints.regenerative.sketch;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.datums.JoCoSys;
import eu.bopet.jocadv.core.features.sketch.JoSketch;
import eu.bopet.jocadv.core.features.vector.JoValue;

import java.util.Set;

public class CoordinateSystemSketch implements RegenerativeLink {
    private JoCoSys referenceCoordinateSystem;
    private final JoSketch resultSketch;

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
    public Feature getResult() {
        return resultSketch;
    }

    @Override
    public Set<JoValue> getValues() {
        return referenceCoordinateSystem.getValues();
    }

    @Override
    public String toString() {
        return "CoordinateSystemSketch{" +
                "referenceCoordinateSystem=" + referenceCoordinateSystem +
                ", resultSketch=" + resultSketch +
                '}';
    }
}
