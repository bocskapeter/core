package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilIntInt;

public class DateAndTime extends UtilIntInt {
    public DateAndTime(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "DateAndTime{" + super.toString() + "}";
    }
}
