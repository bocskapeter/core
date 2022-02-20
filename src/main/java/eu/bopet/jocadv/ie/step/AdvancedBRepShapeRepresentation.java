package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.ie.step.util.UtilSetOfIntInt;

public class AdvancedBRepShapeRepresentation extends UtilSetOfIntInt {

    public AdvancedBRepShapeRepresentation(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "AdvancedBRepShapeRepresentation{" + super.toString() + '}';
    }
}
