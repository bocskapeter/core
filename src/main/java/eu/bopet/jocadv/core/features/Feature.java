package eu.bopet.jocadv.core.features;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.features.vector.JoValue;

import java.util.LinkedHashSet;
import java.util.Set;

public interface Feature {
    /**
     * @return regenerative link
     */
    RegenerativeLink getRegenerativeLink();

    /**
     * @return list of values used in this feature
     */
    default Set<JoValue> getValues() {
        Set<JoValue> result = new LinkedHashSet<>();
        if (getRegenerativeLink()!=null) {
            result.addAll(getRegenerativeLink().getValues());
        }
        return result;
    }

    /**
     * store all values
     */
    default void store(){
        Set<JoValue> values = new LinkedHashSet<>();
        if (getRegenerativeLink()!=null) {
            values.addAll(getRegenerativeLink().getValues());
        }
        for (JoValue value : values) value.store();
    }
}
