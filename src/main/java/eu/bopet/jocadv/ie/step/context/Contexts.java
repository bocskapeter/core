package eu.bopet.jocadv.ie.step.context;

import eu.bopet.jocadv.ie.step.util.StepCode;
import eu.bopet.jocadv.ie.step.util.StepEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
        List<String> contextStringList = new ArrayList<>();
        for (int i = 0; i < (index.size()); i++) {
            int lastIndex = set.length();
            if (i + 1 < index.size()) {
                lastIndex = index.get(i + 1);
            }
            String s = set.substring(index.get(i), lastIndex);
            if (s.contains(StepCode.REPRESENTATION_CONTEXT)) {
                int first = s.indexOf(StepCode.REPRESENTATION_CONTEXT);
                int last = s.lastIndexOf(StepCode.REPRESENTATION_CONTEXT);
                if (first == last) {
                    if (first != 0) {
                        if (s.charAt(first - 1) == '_') {
                            contextStringList.add(s);
                        } else {
                            String firstPart = s.substring(0, last);
                            String lastPart = s.substring(last);
                            contextStringList.add(firstPart);
                            contextStringList.add(lastPart);
                        }
                        continue;
                    }
                } else {
                    String firstPart = s.substring(0, last);
                    String lastPart = s.substring(last);
                    contextStringList.add(firstPart);
                    contextStringList.add(lastPart);
                    continue;
                }
            }
            contextStringList.add(s);
        }

        System.out.println("Contexts: " + contextStringList);

        for (String contextString : contextStringList) {
            String code = contextString.substring(0, contextString.indexOf("(")).replace(" ", "");
            String attribute = contextString.substring(contextString.indexOf("(") + 1, contextString.lastIndexOf(")"));
            System.out.println("Atribute: " + attribute);
            switch (code) {
                case StepCode.ANALYSIS_REPRESENTATION_CONTEXT: {
                    break;
                }
                case StepCode.GEOMETRIC_REPRESENTATION_CONTEXT: {
                    int ident = Integer.parseInt(attribute);
                    GeometricRepresentationContext context = new GeometricRepresentationContext("", "", ident);
                    contexts.add(context);
                    System.out.println(context);
                    break;
                }
                case StepCode.GLOBAL_UNCERTAINTY_ASSIGNED_CONTEXT: {
                    break;
                }
                case StepCode.GLOBAL_UNIT_ASSIGNED_CONTEXT: {
                    break;
                }
                case StepCode.PARAMETRIC_REPRESENTATION_CONTEXT: {
                    break;
                }
                case StepCode.PATH_PARAMETRIC_REPRESENTATION_CONTEXT: {
                }
                case StepCode.REPRESENTATION_CONTEXT: {
                }
            }
            continue;
        }
    }

    @Override
    public String toString() {
        return "Contexts{id=" + super.getId() +
                " , contexts=" + contexts +
                '}';
    }
}
