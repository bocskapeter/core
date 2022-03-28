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
    private JoPoint joPoint;
    private JoValue x;
    private JoValue y;
    private JoValue z;

    public CartesianPoint(int id, String name, String attributes) {
        super(id, name, attributes);
    }

    @Override
    public JoFeature getResult(List<StepEntityBase> entityList) {
        if (joPoint != null) {
            return joPoint;
        }
        double[] doubles = this.getDoubles();
        x = new JoValue(JoValue.IMPORTED, doubles[0]);
        y = new JoValue(JoValue.IMPORTED, doubles[1]);

        if (doubles.length == 3) {
            z = new JoValue(JoValue.IMPORTED, doubles[2]);
        }
        if (doubles.length == 2) {
            z = new JoValue(JoValue.IMPORTED, 0.0);
        }
        JoVector vector = new JoVector(x, y, z, null);
        joPoint = new JoPoint(vector, null);
        return joPoint;
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
