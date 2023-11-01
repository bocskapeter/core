package eu.bopet.jocadv.core.features.protrusion;

import eu.bopet.jocadv.core.features.JoBaseFeature;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.sketch.JoSValue;
import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.sketch.JoSketch;

import java.util.Objects;
import java.util.Set;

public class JoExtrude extends JoBaseFeature implements JoFeature, RegenerativeLink {
    private final JoSketch sketch;
    private final JoFeature path;
    private final JoFeature start;
    private final JoFeature end;
    private final JoSValue pitch;
    private final RegenerativeLink regenerativeLink;

    public JoExtrude(JoSketch sketch, JoFeature path, JoFeature start, JoFeature end, JoSValue pitch, RegenerativeLink regenerativeLink) {
        this.sketch = sketch;
        this.path = path;
        this.start = start;
        this.end = end;
        this.pitch = Objects.requireNonNullElseGet(pitch, () -> new JoSValue(JoSValue.AUTO, Double.POSITIVE_INFINITY));
        this.regenerativeLink = regenerativeLink;
    }

    @Override
    public void regenerate() {
    }

    @Override
    public JoFeature getResult() {
        return null;
    }

    @Override
    public RegenerativeLink getRegenerativeLink() {
        return null;
    }

    @Override
    public void setRegenerativeLink(RegenerativeLink newRegenerativeLink) {

    }

    @Override
    public Set<JoSValue> getValues() {
        return JoFeature.super.getValues();
    }

    @Override
    public void store() {
        JoFeature.super.store();
    }

    @Override
    public boolean isOn(JoPoint point) {
        // TODO point on extrude
        return false;
    }
}
