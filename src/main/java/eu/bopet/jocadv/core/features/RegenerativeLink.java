package eu.bopet.jocadv.core.features;

import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.JoValue;

import java.util.Set;

public interface RegenerativeLink {
    /**
     * regenerate the feature based on the references stored in the list of regenerative links
     */
    void regenerate() throws Exception;

    /**
     * @return result feature
     */
    JoFeature getResult();

    /**
     * @return list of values used as reference for this regenerative link
     */
    Set<JoValue> getValues();
}