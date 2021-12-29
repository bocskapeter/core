package eu.bopet.jocadv.core.constraints.feature;

import eu.bopet.jocadv.core.features.Feature;

public interface RegenerativeLink {
    /**
     * regenerate the feature based on the references stored in the list of regenerative links
     */
    void regenerate();

    /**
     * @return result feature
     */
    Feature getResult();
}
