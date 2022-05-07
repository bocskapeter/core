package eu.bopet.jocadv.core.features;

import eu.bopet.jocadv.core.features.exception.NotCompatibleRegenerativeLinkException;

import java.util.LinkedHashSet;
import java.util.Set;

public interface JoFeature {
    /**
     * @return regenerative link
     */
    RegenerativeLink getRegenerativeLink();

    /**
     * @param newRegenerativeLink - the new regenerative link
     */
    default void replaceReferenceLink(RegenerativeLink newRegenerativeLink) throws Exception {
        if (!(newRegenerativeLink.getResult().getClass() == getRegenerativeLink().getClass())) {
            throw new NotCompatibleRegenerativeLinkException(getRegenerativeLink(), newRegenerativeLink);
        }
        setRegenerativeLink(newRegenerativeLink);
    }

    void setRegenerativeLink(RegenerativeLink newRegenerativeLink);

    /**
     * @return list of values used in this feature
     */
    default Set<JoValue> getValues() {
        Set<JoValue> result = new LinkedHashSet<>();
        if (getRegenerativeLink() != null) {
            result.addAll(getRegenerativeLink().getValues());
        }
        return result;
    }

    /**
     * store all values
     */
    default void store() {
        Set<JoValue> values = new LinkedHashSet<>();
        if (getRegenerativeLink() != null) {
            values.addAll(getRegenerativeLink().getValues());
        }
        for (JoValue value : values) value.store();
    }
}
