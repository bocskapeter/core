package eu.bopet.jocadv.ie.step.surface;

import eu.bopet.jocadv.ie.step.util.StepCode;
import eu.bopet.jocadv.ie.step.util.StepEntityBase;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Surfaces extends StepEntityBase {
    private Set<Surface> surfaces;

    public Surfaces(int id, String name, String set) {
        super(id, name);
        surfaces = new LinkedHashSet<>();
        System.out.println(" SET: " + set);
        List<String> surfaceStringList = StepEntityBase.getSets(set, StepCode.SURFACES);
        for (String s : surfaceStringList) {
            System.out.println("s: " + s);
        }
    }
}
