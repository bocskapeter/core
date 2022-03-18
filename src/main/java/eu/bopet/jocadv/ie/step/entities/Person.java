package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.StepEntityBase;

import java.util.ArrayList;
import java.util.List;

public class Person extends StepEntityBase {
    private String lastName;
    private String firstName;
    private List<String> middleNames;
    private String prefix;
    private String suffix;

    public Person(int id, String identifier, String attribute) {
        super(id, identifier);
        String[] parts = attribute.replace("'", "").split(",");
        lastName = parts[0];
        firstName = parts[1];
        middleNames = new ArrayList<>();
        String[] middleNamesString = attribute.substring(attribute.indexOf(",(") + 2, attribute.indexOf("),")).split(",");
        for (String s : middleNamesString) {
            middleNames.add(s);
        }
        String[] lastParts = attribute.substring(attribute.indexOf("),") + 2).split(",");
        prefix = lastParts[0];
        suffix = lastParts[1];
    }

    @Override
    public String toString() {
        return "Person{" + super.toString() +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleNames=" + middleNames +
                ", prefix='" + prefix + '\'' +
                ", suffix='" + suffix + '\'' +
                '}';
    }
}
