package eu.bopet.jocadv.core.features;

import org.apache.commons.math3.geometry.euclidean.threed.Line;

public interface Selectable {
    /**
     * @param pickingLine - a picking line
     * @return the distance between the geometry and the picking line
     */
    double distance(Line pickingLine);
}
