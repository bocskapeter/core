package eu.bopet.jocadv.core.features;

import eu.bopet.jocadv.core.constraints.feature.Regenerative;

import java.util.ArrayList;
import java.util.List;

public class JoPart extends Base {
    private final List<Regenerative> regenerativeList;
    private final List<Feature> features;

    public JoPart() {
        regenerativeList = new ArrayList<>();
        features = new ArrayList<>();

    }
}
