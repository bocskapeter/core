package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.ie.step.util.UtilListOfInt;

public class EdgeLoop extends UtilListOfInt {
    public EdgeLoop(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "EdgeLoop{" + super.toString() + '}';
    }
}
