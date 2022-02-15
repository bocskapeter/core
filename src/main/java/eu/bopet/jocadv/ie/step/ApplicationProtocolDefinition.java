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

    public static ApplicationProtocolDefinition getInstance(int id, String name, String attribute) {
        String[] values = attribute.split(",");
        String modelSchemaName = values[0].replace("'", "").stripLeading();
        int year = Integer.parseInt(values[1]);
        int contextId = Integer.parseInt(values[2].substring(1));
        ApplicationProtocolDefinition applicationProtocolDefinition =
                new ApplicationProtocolDefinition(modelSchemaName, year, contextId);
        applicationProtocolDefinition.setId(id);
        applicationProtocolDefinition.setName(name);
        return applicationProtocolDefinition;
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
