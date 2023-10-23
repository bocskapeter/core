package eu.bopet.jocadv.ie.step;

public interface StepLink {
    /**
     * @return result feature
     */
    void generateJoFeature(StepFeature feature) throws Exception;

    /**
     * regenerate the feature based on the references of the step entities
     */
    void regenerate() throws Exception;
}
