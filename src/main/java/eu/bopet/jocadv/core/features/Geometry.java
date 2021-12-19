package eu.bopet.jocadv.core.features;

import eu.bopet.jocadv.core.features.datums.vector.JoValue;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.List;

public interface Geometry {

    /**
     * @param pickingLine - a picking line
     * @return the distance between the geometry and the picking line
     */
    double distance(Line pickingLine);

    /**
     * @return List of Values
     */
    List<JoValue> getValues();
}
