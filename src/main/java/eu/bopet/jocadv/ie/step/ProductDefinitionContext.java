package eu.bopet.jocadv.ie.step;

public class ProductDefinitionContext extends StepEntity {
    private int applicationContextId;
    private String lifeCycleStage;

    public ProductDefinitionContext(int applicationContextId, String lifeCycleStage) {
        this.applicationContextId = applicationContextId;
        this.lifeCycleStage = lifeCycleStage;
    }

    @Override
    public String toString() {
        return "ProductDefinitionContext{" + super.toString() +
                " applicationContextId=" + applicationContextId +
                ", lifeCycleStage='" + lifeCycleStage + '\'' +
                '}';
    }
}
