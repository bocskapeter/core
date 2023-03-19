package eu.bopet.jocadv.core.features.sketch.exception;

import eu.bopet.jocadv.core.features.sketch.SketchGeometry;

public class SelfIntersectionException extends Exception {
    private final SketchGeometry geometry1;
    private final SketchGeometry geometry2;

    public SelfIntersectionException(SketchGeometry geometry1, SketchGeometry geometry2) {
        this.geometry1 = geometry1;
        this.geometry2 = geometry2;
    }

    @Override
    public String toString() {
        return "SelfIntersectionException{" +
                "geometry1=" + geometry1 +
                ", geometry2=" + geometry2 +
                '}';
    }
}
