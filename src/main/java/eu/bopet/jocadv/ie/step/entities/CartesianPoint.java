package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.vector.JoVector;
import eu.bopet.jocadv.ie.step.StepFeature;
import eu.bopet.jocadv.ie.step.StepLink;
import eu.bopet.jocadv.ie.step.util.UtilDoubleArray;

public class CartesianPoint extends UtilDoubleArray implements SelectedTrim, StepLink {

    public CartesianPoint(int id, String name, String attributes) {
        super(id, name, attributes);
    }

    @Override
    public void generateJoFeature(StepFeature feature) {
        double[] doubles = super.getDoubles();
        JoValue x = new JoValue(JoValue.IMPORTED, doubles[0]);
        JoValue y = new JoValue(JoValue.IMPORTED, doubles[1]);
        JoValue z = new JoValue(JoValue.IMPORTED, 0.0);
        if (doubles.length > 2) {
            z = new JoValue(JoValue.IMPORTED, doubles[2]);
        }
        JoVector vector = new JoVector(x, y, z, null);
        JoPoint joPoint = new JoPoint(vector, null);
        joPoint.setIntID(this.getId());
        joPoint.setName(this.getName());
        feature.getFeatureMap().put(this, joPoint);
    }

    @Override
    public void regenerate() throws Exception {
        // TODO
    }

    @Override
    public String toString() {
        return "CartesianPoint{" + super.toString() + '}';
    }

}
