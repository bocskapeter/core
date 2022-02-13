package eu.bopet.jocadv.ie.step;

public class ProductContext extends StepEntity {
    private int applicationContextId;
    private String disciplineType;

    public ProductContext(int applicationContextId, String disciplineType) {
        this.applicationContextId = applicationContextId;
        this.disciplineType = disciplineType;
    }

    @Override
    public String toString() {
        return "ProductDefinitionContext{" + super.toString() +
                " applicationContextId=" + applicationContextId +
                ", disciplineType='" + disciplineType + '\'' +
                '}';
    }
}
