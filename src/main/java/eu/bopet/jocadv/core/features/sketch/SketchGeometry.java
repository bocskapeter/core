package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.basic.JoPoint;

import java.util.List;
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
    List<JoPoint> getIntersection(SketchGeometry geometry);
}
