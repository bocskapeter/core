package eu.bopet.jocadv.core.constraints.regenerative.feature;

import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.basic.JoFace;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.sketch.JoSketch;
import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;

import java.util.HashSet;
import java.util.Set;

public class SketchDirectionPlaneFace implements RegenerativeLink {
    private JoSketch referenceSketch;
    private JoVector referenceDirection;
    private JoPlane referencePlane;
    private final Set<JoFeature> loop;
    private final JoFace resultFace;

    public SketchDirectionPlaneFace(JoSketch referenceSketch, JoVector referenceDirection, JoPlane referencePlane) {
        this.referenceSketch = referenceSketch;
        this.referenceDirection = referenceDirection;
        this.referencePlane = referencePlane;
        this.loop = new HashSet<>();

        // TODO complete class
        this.resultFace = new JoFace(referenceDirection, loop, this);
    }

    @Override
    public void regenerate() throws Exception {

    }

    @Override
    public JoFeature getResult() {
        return null;
    }

    @Override
    public Set<JoValue> getValues() {
        return null;
    }
}
