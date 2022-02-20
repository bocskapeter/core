package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.ie.step.util.UtilIntDouble;

public class Circle extends UtilIntDouble {

    public Circle(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "Circle{" + super.toString() + '}';
    }
}
