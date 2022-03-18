package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilIntIntInt;

public class CalendarDate extends UtilIntIntInt {
    public CalendarDate(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "CalendarDate{" + super.toString() + "}";
    }
}
