package eu.bopet.jocadv.core.features.protrusion;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.FeatureBase;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.SketchNotLoopException;
import eu.bopet.jocadv.core.features.sketch.JoSketch;
import eu.bopet.jocadv.core.features.sketch.SketchGeometry;
import eu.bopet.jocadv.core.features.vector.JoValue;

import java.util.LinkedHashSet;
import java.util.Set;

public class Extrude extends FeatureBase implements Feature, RegenerativeLink {
    private final JoSketch sketch;
    private final Feature direction;
    private final Feature limit;

    public Extrude(JoSketch sketch, Feature direction, Feature limit) throws Exception {
        this.sketch = sketch;
        this.direction = direction;
        this.limit = limit;
        checkSketch();
    }

    private void checkSketch() throws Exception {
        for (SketchGeometry geometry : sketch.getGeometries()) {
            Set<SketchGeometry> rest = new LinkedHashSet<>(sketch.getGeometries());
            rest.remove(geometry);
            for (SketchGeometry otherGeometry : rest) {
                JoPoint intersection = geometry.getIntersection(otherGeometry);
                if (intersection != null) {
                    throw new SketchNotLoopException(intersection);
                }
            }
        }
    }

    @Override
    public void regenerate() throws Exception {
        checkSketch();
    }

    @Override
    public Feature getResult() {
        return null;
    }

    @Override
    public RegenerativeLink getRegenerativeLink() {
        return null;
    }

    @Override
    public Set<JoValue> getValues() {
        return Feature.super.getValues();
    }

    @Override
    public void store() {
        Feature.super.store();
    }
}
