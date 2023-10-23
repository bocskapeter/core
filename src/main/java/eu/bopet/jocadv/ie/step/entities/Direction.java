package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;
import eu.bopet.jocadv.ie.step.StepFeature;
import eu.bopet.jocadv.ie.step.StepLink;
import eu.bopet.jocadv.ie.step.util.UtilDoubleArray;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

public class Direction extends UtilDoubleArray implements StepLink {

    public Direction(int id, String name, String attributes) {
        super(id, name, attributes);
    }

    @Override
    public String toString() {
        return "Direction{" + super.toString() + '}';
    }

    @Override
    public void generateJoFeature(StepFeature feature) {
        double z = 0.0;
        if (super.getDoubles().length > 2) {
            z = super.getDoubles()[2];
        }
        Vector3D vector3D = new Vector3D(super.getDoubles()[0], super.getDoubles()[1], z);
        JoVector joVector = new JoVector(JoValue.IMPORTED, vector3D);
        feature.getFeatureMap().put(this, joVector);
    }

    @Override
    public void regenerate() throws Exception {

    }
}
