package eu.bopet.jocadv.core.features;

import eu.bopet.jocadv.core.features.exception.NotCompatibleRegenerativeLinkException;
import eu.bopet.jocadv.core.features.sketch.JoSValue;

import java.util.LinkedHashSet;
import java.util.Set;

public interface JoFeature {
    /**
     * @return regenerative link
     */
    RegenerativeLink getRegenerativeLink();

    void setRegenerativeLink(RegenerativeLink newRegenerativeLink);

    /**
     * @param newRegenerativeLink - the new regenerative link
     */
    default void replaceReferenceLink(RegenerativeLink newRegenerativeLink) throws Exception {
        if (!(newRegenerativeLink.getResult().getClass() == getRegenerativeLink().getClass())) {
            throw new NotCompatibleRegenerativeLinkException(getRegenerativeLink(), newRegenerativeLink);
        }
        setRegenerativeLink(newRegenerativeLink);
    }

    /**
     * @return list of values used in this feature
     */
    default Set<JoSValue> getValues() {
        Set<JoSValue> result = new LinkedHashSet<>();
        if (getRegenerativeLink() != null) {
            result.addAll(getRegenerativeLink().getValues());
        }
        return result;
    }

    /**
     * store all values
     */
    default void store() {
        Set<JoSValue> values = new LinkedHashSet<>();
        if (getRegenerativeLink() != null) {
            values.addAll(getRegenerativeLink().getValues());
        }
        for (JoSValue value : values) value.store();
    }
}
