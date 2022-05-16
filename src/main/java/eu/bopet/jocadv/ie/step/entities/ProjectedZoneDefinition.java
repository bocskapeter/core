package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilIntSetOfInt;

public class ProjectedZoneDefinition extends UtilIntSetOfInt {
    private int projectionEnd;
    private int projectedLength;

    public ProjectedZoneDefinition(int id, String name, String attribute) {
        super(id, name, attribute);
        String[] rest = attribute.substring(attribute.lastIndexOf("),") + 2).split(",");
        projectionEnd = Integer.parseInt(rest[0].replace("#", ""));
        projectedLength = Integer.parseInt(rest[1].replace("#", ""));
    }

    @Override
    public String toString() {
        return "ProjectedZoneDefinition{" + super.toString() +
                ", projectionEnd=" + projectionEnd +
                ", projectedLength=" + projectedLength +
                '}';
    }
}
