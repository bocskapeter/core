package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringIntInt;

public class ModelGeometricView extends UtilStringIntInt {
    public ModelGeometricView(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "ModelGeometricView{" + super.toString() + "}";
    }
}
