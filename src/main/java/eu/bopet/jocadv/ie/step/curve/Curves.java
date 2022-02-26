package eu.bopet.jocadv.ie.step.curve;

import eu.bopet.jocadv.ie.step.util.StepCode;
import eu.bopet.jocadv.ie.step.util.StepEntity;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Curves extends StepEntity {
    private Set<Curve> curves;

    public Curves(int id, String name, String set) {
        super(id, name);
        curves = new LinkedHashSet<>();
        System.out.println("Set: " + set);
        String rest = set;
        List<String> curveStringList = new ArrayList<>();
        for (String code : StepCode.CURVES) {
            if (set.contains(code)) {
                while (rest.contains(code)) {
                    String cut = rest.substring(rest.indexOf(code) + code.length());
                    int lastBracket = 0;
                    int brackets = 0;
                    for (int i = 0; i < cut.length(); i++) {
                        if (cut.charAt(i) == '(') {
                            brackets++;
                        }
                        if (cut.charAt(i) == ')') {
                            brackets--;
                        }
                        if (brackets == 0) {
                            lastBracket = i;
                            break;
                        }
                    }
                    String attribute = cut.substring(0, lastBracket + 1);
                    curveStringList.add(code + attribute);
                    int backIndex = rest.indexOf(code) + code.length() + attribute.length();
                    String front = rest.substring(0, rest.indexOf(code));
                    String back = rest.substring(backIndex);
                    rest = front + back;
                }
            }
        }
        for (String s : curveStringList) {
            System.out.println(s);
        }

    }
}
