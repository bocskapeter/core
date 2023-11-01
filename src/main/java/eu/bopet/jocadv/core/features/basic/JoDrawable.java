package eu.bopet.jocadv.core.features.basic;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

public interface JoDrawable {
    Vector3D[] getPoints(double accuracy);
}
