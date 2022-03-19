package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;
import eu.bopet.jocadv.ie.step.StepLink;
import eu.bopet.jocadv.ie.step.util.StepEntityBase;
import eu.bopet.jocadv.ie.step.util.UtilDoubleArray;

import java.util.List;

public class CartesianPoint extends UtilDoubleArray implements SelectedTrim, StepLink {
    private JoFeature feature;

    public CartesianPoint(int id, String name, String attributes) {
        super(id, name, attributes);
    }

    @Override
    public JoFeature getResult(List<StepEntityBase> entityList) {
        if (feature != null) {
            return feature;
        }
        double[] doubles = this.getDoubles();
        if (doubles.length == 3) {
            JoValue x = new JoValue(JoValue.IMPORTED, doubles[0]);
            JoValue y = new JoValue(JoValue.IMPORTED, doubles[1]);
            JoValue z = new JoValue(JoValue.IMPORTED, doubles[2]);
            JoVector vector = new JoVector(x, y, z, null);
            feature = new JoPoint(vector, null);
            return feature;
        }
        return null;
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
