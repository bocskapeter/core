package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntity;

import java.util.LinkedHashSet;
import java.util.Set;

public class CCDesignApproval extends StepEntity {
    private int approval;
    private Set<Integer> items;

    public CCDesignApproval(int id, String name, String attribute) {
        super(id, name);
        approval = Integer.parseInt(attribute.substring(0, attribute.indexOf(",(")).replace("#", ""));
        items = new LinkedHashSet<>();
        String[] itemStrings = attribute.substring(attribute.indexOf(",(") + 1).replace("(", "").replace(")", "").split(",");
        for (String s : itemStrings) {
            items.add(Integer.parseInt(s.replace("#", "")));
        }
    }

    @Override
    public String toString() {
        return "CCDesignApproval{" + super.toString() +
                ", approval=" + approval +
                ", items=" + items +
                '}';
    }
}
