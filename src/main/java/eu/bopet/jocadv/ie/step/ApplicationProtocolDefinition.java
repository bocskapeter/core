package eu.bopet.jocadv.ie.step;

public class ApplicationProtocolDefinition extends StepEntity {
    private String modelSchemaName;
    private int year;
    private int contextId;

    public ApplicationProtocolDefinition(String modelSchemaName, int year, int contextId) {
        this.modelSchemaName = modelSchemaName;
        this.year = year;
        this.contextId = contextId;
    }

    @Override
    public String toString() {
        return "ApplicationProtocolDefinition{" + super.toString() +
                " modelSchemaName='" + modelSchemaName + '\'' +
                ", year=" + year +
                ", contextId=" + contextId +
                '}';
    }
}
