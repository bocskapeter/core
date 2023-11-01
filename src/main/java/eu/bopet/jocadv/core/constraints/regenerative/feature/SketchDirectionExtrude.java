package eu.bopet.jocadv.core.constraints.regenerative.feature;

import eu.bopet.jocadv.core.constraints.regenerative.plane.OffsetPlane;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.sketch.JoSValue;
import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.protrusion.JoExtrude;
import eu.bopet.jocadv.core.features.sketch.JoSketch;
import eu.bopet.jocadv.core.features.vector.JoVector;

import java.util.Set;

public class SketchDirectionExtrude implements RegenerativeLink {
    private JoSketch referenceSketch;
    private JoVector referenceDirection;
    private JoSValue referenceStart;
    private JoSValue referenceEnd;

    private OffsetPlane statPlane;
    private OffsetPlane endPlane;

    private JoExtrude resultExtrude;

    public SketchDirectionExtrude(JoSketch referenceSketch, JoVector referenceDirection, JoSValue referenceStart, JoSValue referenceEnd) {
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
    public JoFeature getResult() {
        return null;
    }

    @Override
    public Set<JoSValue> getValues() {
        return null;
    }
}
