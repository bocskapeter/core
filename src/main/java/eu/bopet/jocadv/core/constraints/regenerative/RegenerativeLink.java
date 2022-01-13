package eu.bopet.jocadv.core.constraints.regenerative;

import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.vector.JoValue;

import java.util.List;

public interface RegenerativeLink {
    /**
     * regenerate the feature based on the references stored in the list of regenerative links
     */
    void regenerate() throws Exception;

    /**
     * @return result feature
     */
    Feature getResult();

    /**
     * @return list of values used for this regenerative link
     */
    List<JoValue> getValues();
}
