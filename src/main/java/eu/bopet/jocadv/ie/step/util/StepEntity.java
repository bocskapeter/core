package eu.bopet.jocadv.ie.step.util;

import java.util.ArrayList;
import java.util.List;

public abstract class StepEntity {
    private int id;
    private String name;

    public StepEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<String> getSets(String set, String[] sets) {
        List<String> result = new ArrayList<>();
        String rest = set;
        for (String code : sets) {
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
                    result.add(code + attribute);
                    int backIndex = rest.indexOf(code) + code.length() + attribute.length();
                    String front = rest.substring(0, rest.indexOf(code));
                    String back = rest.substring(backIndex);
                    rest = front + back;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name='" + name + '\'';
    }
}
