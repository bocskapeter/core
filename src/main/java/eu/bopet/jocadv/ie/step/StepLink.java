package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.ie.step.util.StepEntityBase;

import java.util.List;

public interface StepLink {
    /**
     * @return result feature
     */
    JoFeature getResult(List<StepEntityBase> entityList);

    /**
     * regenerate the feature based on the references of the step entities
     */
    void regenerate() throws Exception;
}
