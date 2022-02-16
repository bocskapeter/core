package eu.bopet.jocadv.ie.step;

public class RepresentationContext extends StepEntity {
    private String contextType;

    public RepresentationContext(String contextType) {
        this.contextType = contextType;
    }

    @Override
    public String toString() {
        return "RepresentationContext{" + super.toString() +
                " contextType='" + contextType + '\'' +
                '}';
    }
}
