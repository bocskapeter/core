package eu.bopet.jocadv.ie.step;

public class ProductContext extends StepEntity {
    private int applicationContextId;
    private String disciplineType;

    public ProductContext(int applicationContextId, String disciplineType) {
        this.applicationContextId = applicationContextId;
        this.disciplineType = disciplineType;
    }

    public static ProductContext getInstance(int id, String name, String attribute) {
        String[] values = attribute.split(",");
        int applicationContextId = Integer.parseInt(values[0].substring(1));
        String lifeCycleStage = values[1].replace("'", "");
        ProductContext productContext =
                new ProductContext(applicationContextId, lifeCycleStage);
        productContext.setId(id);
        productContext.setName(name);
        return productContext;
    }

    @Override
    public String toString() {
        return "ProductDefinitionContext{" + super.toString() +
                " applicationContextId=" + applicationContextId +
                ", disciplineType='" + disciplineType + '\'' +
                '}';
    }
}
