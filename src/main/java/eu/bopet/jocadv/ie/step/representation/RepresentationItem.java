package eu.bopet.jocadv.ie.step.representation;

import eu.bopet.jocadv.ie.step.curve.Curve;
import eu.bopet.jocadv.ie.step.measure.Measure;
import eu.bopet.jocadv.ie.step.surface.Surface;

public class RepresentationItem implements Curve, Surface, Measure {
    private final String name;

    public RepresentationItem() {
        name = "";
    }

    public RepresentationItem(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RepresentationItem{" + name + "}";
    }
}
