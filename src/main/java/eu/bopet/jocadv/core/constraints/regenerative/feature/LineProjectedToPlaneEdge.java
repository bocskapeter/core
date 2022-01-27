package eu.bopet.jocadv.core.constraints.regenerative.feature;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.constraints.regenerative.point.ToPlaneProjectedPoint;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.JoEdge;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.sketch.JoLine;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;

import java.util.Set;

public class LineProjectedToPlaneEdge implements RegenerativeLink {
    private JoLine referenceLine;
    private JoPlane referencePlane;
    private JoVector referenceDirection;

    private ToPlaneProjectedPoint projected1stPoint;

    private final JoEdge resultEdge;

    public LineProjectedToPlaneEdge(JoLine referenceLine, JoPlane referencePlane, JoVector referenceDirection) {
        this.referenceLine = referenceLine;
        this.referencePlane = referencePlane;
        this.referenceDirection = referenceDirection;

        resultEdge = new JoEdge();
    }

    @Override
    public void regenerate() throws Exception {

    }

    @Override
    public Feature getResult() {
        return resultEdge;
    }

    @Override
    public Set<JoValue> getValues() {
        return null;
    }
}
