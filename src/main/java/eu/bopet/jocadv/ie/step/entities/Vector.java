package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;
import eu.bopet.jocadv.ie.step.StepFeature;
import eu.bopet.jocadv.ie.step.StepLink;
import eu.bopet.jocadv.ie.step.util.UtilIntDouble;

public class Vector extends UtilIntDouble implements StepLink {

    public Vector(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "Vector{" + super.toString() + '}';
    }

    @Override
    public void generateJoFeature(StepFeature feature) {
        Direction direction = (Direction) feature.getStepEntityByID(super.get1st());
        if (!feature.getFeatureMap().containsKey(direction)) {
            direction.generateJoFeature(feature);
        }
        JoVector joDirectionVector = (JoVector) feature.getFeatureMap().get(direction);
        JoVector joVector = new JoVector(JoValue.IMPORTED,
                joDirectionVector.getVector3D().scalarMultiply(super.get2nd()));
        feature.getFeatureMap().put(this, joVector);
    }

    @Override
    public void regenerate() throws Exception {

    }
}
