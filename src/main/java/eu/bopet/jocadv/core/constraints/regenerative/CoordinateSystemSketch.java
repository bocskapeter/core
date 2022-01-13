package eu.bopet.jocadv.core.constraints.regenerative;

import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.datums.JoCoSys;
import eu.bopet.jocadv.core.features.sketch.JoSketch;
import eu.bopet.jocadv.core.features.vector.JoValue;

import java.util.List;

public class CoordinateSystemSketch implements RegenerativeLink {
    private final JoCoSys referenceCoordinateSystem;
    private final JoSketch resultSketch;

    public CoordinateSystemSketch(JoCoSys referenceCoordinateSystem) {
        this.referenceCoordinateSystem = referenceCoordinateSystem;
        this.resultSketch = new JoSketch(referenceCoordinateSystem, this);
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
    public List<JoValue> getValues() {
        return null;
    }
}
