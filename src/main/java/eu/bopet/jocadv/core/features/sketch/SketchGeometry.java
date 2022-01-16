package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.vector.JoValue;

import java.util.Set;

public interface SketchGeometry {

    /**
     * @return List of Values
     */
    Set<JoValue> getValues();

    /**
     * @return List of Points
     */
    Set<JoPoint> getPoints();

    /**
     * @param geometry the other geometry
     * @return the intersection point
     */
    JoPoint getIntersection(SketchGeometry geometry);
}
