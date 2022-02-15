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

    public static ProductDefinition getInstance(int id, String name, String attribute) {
        String[] values = attribute.split(",");
        String description = values[0].replace("'", "");
        int formationId = Integer.parseInt(values[1].substring(1));
        int contextID = Integer.parseInt(values[2].substring(1));
        ProductDefinition productDefinition =
                new ProductDefinition(description, formationId, contextID);
        productDefinition.setId(id);
        productDefinition.setName(name);
        return productDefinition;
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
