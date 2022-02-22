package eu.bopet.jocadv.ie.step.context;

import eu.bopet.jocadv.ie.step.util.StepCode;
import eu.bopet.jocadv.ie.step.util.StepEntity;

import java.util.*;

public class Contexts extends StepEntity {
    private Set<Context> contexts;

    public Contexts(int id, String name, String set) {
        super(id, name);
        System.out.println("Processing set of " + set);
        this.contexts = new LinkedHashSet<>();
        List<Integer> index = new ArrayList<>();
        for (String code : StepCode.CONTEXTS) {
            if (set.contains(code)) {
                index.add(set.indexOf(code));
            }
        }
        Collections.sort(index);
        System.out.println("index: " + index);
        //TODO split set to parts..
    }

    @Override
    public String toString() {
        return "Contexts{id=" + super.getId() +
                " , contexts=" + contexts +
                '}';
    }
}
