package eu.bopet.jocadv.ie.step;

public class ProductDefinitionContext extends StepEntity {
    private int applicationContextId;
    private String lifeCycleStage;

    public ProductDefinitionContext(int applicationContextId, String lifeCycleStage) {
        this.applicationContextId = applicationContextId;
        this.lifeCycleStage = lifeCycleStage;
    }

    public static ProductDefinitionContext getInstance(int id, String name, String attribute) {
        String[] values = attribute.split(",");
        int applicationContextId = Integer.parseInt(values[0].substring(1));
        String lifeCycleStage = values[1].replace("'", "");
        ProductDefinitionContext productDefinitionContext =
                new ProductDefinitionContext(applicationContextId, lifeCycleStage);
        productDefinitionContext.setId(id);
        productDefinitionContext.setName(name);
        return productDefinitionContext;
    }

    @Override
    public String toString() {
        return "ProductDefinitionContext{" + super.toString() +
                " applicationContextId=" + applicationContextId +
                ", lifeCycleStage='" + lifeCycleStage + '\'' +
                '}';
    }
}
