package eu.bopet.jocadv.core.features;

import eu.bopet.jocadv.core.features.datums.JoCoSys;

import java.util.ArrayList;
import java.util.List;

public class JoPart extends Feature {
    private final List<Feature> features;

    public JoPart() {
        features = new ArrayList<>();
        features.add(JoCoSys.DEFAULT_COORDINATE_SYSTEM);
    }
}
