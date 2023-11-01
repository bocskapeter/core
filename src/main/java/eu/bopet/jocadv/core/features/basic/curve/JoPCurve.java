package eu.bopet.jocadv.core.features.basic.curve;

import eu.bopet.jocadv.core.features.JoBaseFeature;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

public class JoPCurve extends JoBaseFeature implements JoFeature, Selectable, JoCurve{
    private JoFeature basisSurface;
    private JoFeature reference;

    public JoPCurve(JoFeature basisSurface, JoFeature reference) {
        this.basisSurface = basisSurface;
        this.reference = reference;
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
