package eu.bopet.jocadv.core.features.basic;

import eu.bopet.jocadv.core.features.JoBaseFeature;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.RegenerativeLink;
import eu.bopet.jocadv.core.features.Selectable;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.ArrayList;
import java.util.List;

public class JoEdgeLoop extends JoBaseFeature implements JoFeature, Selectable {
    private List<JoEdge> edges;

    public JoEdgeLoop(List<JoEdge> edges) {
        this.edges = edges;
    }

    public List<JoEdge> getEdges() {
        return edges;
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
