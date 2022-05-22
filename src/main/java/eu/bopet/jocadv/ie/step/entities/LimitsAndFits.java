package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntityBase;

public class LimitsAndFits extends StepEntityBase {
    private String form;
    private String zone;
    private String grade;
    private String source;

    public LimitsAndFits(int id, String name, String attribute) {
        super(id, name);
        String[] parts = attribute.split("'.'");
        form = parts[0].replace("'", "");
        zone = parts[1].replace("'", "");
        grade = parts[2].replace("'", "");
        source = parts[3].replace("'", "");
    }

    @Override
    public String toString() {
        return "LimitsAndFits{" + super.toString() +
                ", form='" + form + '\'' +
                ", zone='" + zone + '\'' +
                ", grade='" + grade + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
