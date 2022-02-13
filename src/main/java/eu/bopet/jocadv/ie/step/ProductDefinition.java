package eu.bopet.jocadv.ie.step;

public class ProductDefinition extends StepEntity {
    private String description;
    private int formationId;
    private int contextID;

    public ProductDefinition(String description, int formationId, int contextID) {
        this.description = description;
        this.formationId = formationId;
        this.contextID = contextID;
    }

    @Override
    public String toString() {
        return "ProductDefinition{" + super.toString() +
                " description='" + description + '\'' +
                ", formationId=" + formationId +
                ", contextID=" + contextID +
                '}';
    }
}
