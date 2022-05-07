package eu.bopet.jocadv.ie.step;

import java.util.ArrayList;
import java.util.List;

public abstract class StepEntityBase {
    private int id;
    private String name;

    public StepEntityBase(int id, String name) {
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

    public static List<String> getSets(String set) {
        List<String> result = new ArrayList<>();
        int firstBracket = set.indexOf("(");
        List<Integer> limiters = new ArrayList<>();
        int brackets = 0;
        for (int i = firstBracket; i < set.length(); i++) {
            if (set.charAt(i) == '(') {
                brackets++;
            }
            if (set.charAt(i) == ')') {
                brackets--;
                if (brackets == 0) {
                    limiters.add(i);
                }
            }
        }
        firstBracket = -1;
        for (int limit : limiters) {
            result.add(set.substring(firstBracket + 1, limit + 1));
            firstBracket = limit;
        }
        return result;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name='" + name + '\'';
    }
}
