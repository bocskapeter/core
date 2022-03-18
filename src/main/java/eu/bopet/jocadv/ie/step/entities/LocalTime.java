package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.StepEntityBase;

public class LocalTime extends StepEntityBase {
    private int hour;
    private int minute;
    private double sec;
    private int zone;

    public LocalTime(int id, String name, String attribute) {
        super(id, name);
        String[] parts = attribute.split(",");
        hour = Integer.parseInt(parts[0]);
        minute = Integer.parseInt(parts[1]);
        sec = Double.parseDouble(parts[2]);
        zone = Integer.parseInt(parts[3].replace("#", ""));
    }

    @Override
    public String toString() {
        return "LocalTime{" + super.toString() +
                ", hour=" + hour +
                ", minute=" + minute +
                ", sec=" + sec +
                ", zone=" + zone +
                '}';
    }
}
