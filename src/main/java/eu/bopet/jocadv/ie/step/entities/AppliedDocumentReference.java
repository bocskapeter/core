package eu.bopet.jocadv.ie.step.entities;

import java.util.LinkedHashSet;
import java.util.Set;

public class AppliedDocumentReference extends DocumentReference {
    private Set<Integer> items;

    public AppliedDocumentReference(int id, String name, String attribute) {
        super(id, name, attribute);
        items = new LinkedHashSet<>();
        String[] itemStrings = attribute.replace("(", "").replace(")", "")
                .substring(attribute.indexOf(",(") + 2).split(",");
        for (String s : itemStrings) {
            items.add(Integer.parseInt(s.replace("#", "")));
        }
    }

    @Override
    public String toString() {
        return "AppliedDocumentReference{" + super.toString() +
                ", items=" + items +
                '}';
    }
}
