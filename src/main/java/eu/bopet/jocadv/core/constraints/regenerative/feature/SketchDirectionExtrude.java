package eu.bopet.jocadv.core.constraints.regenerative.feature;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.constraints.regenerative.plane.OffsetPlane;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.protrusion.JoExtrude;
import eu.bopet.jocadv.core.features.sketch.JoSketch;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;

import java.util.Set;

public class SketchDirectionExtrude implements RegenerativeLink {
    private JoSketch referenceSketch;
    private JoVector referenceDirection;
    private JoValue referenceStart;
    private JoValue referenceEnd;

    private OffsetPlane statPlane;
    private OffsetPlane endPlane;

    private JoExtrude resultExtrude;

    public SketchDirectionExtrude(JoSketch referenceSketch, JoVector referenceDirection, JoValue referenceStart, JoValue referenceEnd) {
        this.referenceSketch = referenceSketch;
        this.referenceDirection = referenceDirection;
        this.referenceStart = referenceStart;
        this.referenceEnd = referenceEnd;
        statPlane = new OffsetPlane(referenceSketch.getCoordinateSystem().getXy(), referenceStart);
        endPlane = new OffsetPlane(referenceSketch.getCoordinateSystem().getXy(), referenceEnd);

        //TODO complete class

    }

    @Override
    public void regenerate() throws Exception {

    }

    @Override
    public Feature getResult() {
        return null;
    }

    @Override
    public Set<JoValue> getValues() {
        return null;
    }
}
