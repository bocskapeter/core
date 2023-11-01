package eu.bopet.jocadv.core.features.surface;

import eu.bopet.jocadv.core.features.JoBaseFeature;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.basic.curve.JoCurve;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

public class JoLinearExtrusionSurface extends JoBaseFeature implements Selectable, JoFeature, JoSurface {
    private JoCurve curve;
    private JoVector vector;

    public JoLinearExtrusionSurface(JoCurve curve, JoVector vector) {
        this.curve = curve;
        this.vector = vector;
    }

    @Override
    public boolean isOn(JoPoint point) {
        return false;
    }

    @Override
    public RegenerativeLink getRegenerativeLink() {
        return null;
    }

    @Override
    public void setRegenerativeLink(RegenerativeLink newRegenerativeLink) {

    }

    @Override
    public double distance(Line pickingLine) {
        return 0;
    }
}
