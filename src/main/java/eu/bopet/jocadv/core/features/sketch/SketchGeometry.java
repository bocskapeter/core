package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.vector.JoValue;

import java.util.List;

public interface SketchGeometry {

    /**
     * @return List of Values
     */
    List<JoValue> getValues();

    /**
     * @return List of Points
     */
    List<JoPoint> getPoints();
}
