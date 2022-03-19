package eu.bopet.jocadv.core.constraints.regenerative.feature;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.constraints.regenerative.point.ToPlaneWithDirectionProjectedPoint;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.basic.JoEdge;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.sketch.JoLine;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;

import java.util.HashSet;
import java.util.Set;

public class LineProjectedToPlaneEdge implements RegenerativeLink {
    private JoLine referenceLine;
    private JoPlane referencePlane;
    private JoVector referenceDirection;

    private ToPlaneWithDirectionProjectedPoint projectedPoint1;
    private ToPlaneWithDirectionProjectedPoint projectedPoint2;
    private Set<JoPoint> points;

    private final JoEdge resultEdge;

    public LineProjectedToPlaneEdge(JoLine referenceLine, JoPlane referencePlane, JoVector referenceDirection)
            throws Exception {
        this.referenceLine = referenceLine;
        this.referencePlane = referencePlane;
        this.referenceDirection = referenceDirection;
        projectedPoint1 = new ToPlaneWithDirectionProjectedPoint(referencePlane,
                this.referenceLine.get1stPoint(), referenceDirection);
        projectedPoint2 = new ToPlaneWithDirectionProjectedPoint(referencePlane,
                this.referenceLine.get2ndPoint(), referenceDirection);
        points = new HashSet<>();
        points.add((JoPoint) projectedPoint1.getResult());
        points.add((JoPoint) projectedPoint2.getResult());
        resultEdge = new JoEdge(points, this);
    }

    @Override
    public void regenerate() throws Exception {
        if (referencePlane.getRegenerativeLink() != null) referencePlane.getRegenerativeLink().regenerate();
        if (referenceDirection.getRegenerativeLink() != null) referenceDirection.getRegenerativeLink().regenerate();
        projectedPoint1.regenerate();
        projectedPoint2.regenerate();
    }

    @Override
    public JoFeature getResult() {
        return resultEdge;
    }

    @Override
    public Set<JoValue> getValues() {
        Set<JoValue> result = new HashSet<>(referenceLine.getValues());
        result.addAll(referencePlane.getValues());
        result.addAll(referenceDirection.getValues());
        return result;
    }
}
