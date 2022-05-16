package eu.bopet.jocadv.ie.step.tolerance;

import eu.bopet.jocadv.ie.step.util.UtilStringIntInt;

public class StraightnessTolerance extends UtilStringIntInt {
    public StraightnessTolerance(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "StraightnessTolerance{" + super.toString() + "}";
    }
}
